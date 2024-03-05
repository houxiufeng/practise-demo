package com.example.demo.suanfa;

import com.example.demo.vo.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 我们知道，递归就是假设子问题已经解决了，那么用子问题的结果来解决原问题。
 * 对于本题，假设原链表是1 -> 2 -> 3 -> 4 -> 5 -> null。
 * 开始时head=1，我们假设1后面的子链表已经反转好了，为5 -> 4 -> 3 -> 2 -> null。
 * 那么只需要接上1就获得了最终答案，接上去的办法就是把2 -> 1。
 * 那么2是啥，2就是head.next，所以head.next.next=head就可以把2 -> 1了。
 * 接着把1 -> null，即head.next=null。
 */
public class LinkListReverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.next = node6;
        System.out.println(head);


//        System.out.println(reverseList(head));
//        System.out.println(reverseList2(head));
        System.out.println(reverseKGroup(head, 3));
    }

    /**
     * 笨办法，按部就班的实现
     * 关键点：链路不能断，在操作之前先把下一点找出来放一边。
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode<Integer> current = head;
        ListNode<Integer> next = current.getNext();
        while(next!= null) {
            if (current.getValue() == 0) {
                current.setNext(null);
            }
            ListNode nextOne = next.getNext();
            next.setNext(current);
            current = next;
            next = nextOne;
        }
        return current;
    }

    /**
     * 用整体话思维思考，先假设是2个元素的问题，按照逻辑处理。
     * 2个元素处理完的结果又整体上能看作是一个元素，因为从宏观上看它本身就是一个节点。
     * 这样继续归并三个元素的处理方式其实又转化为2个元素的处理逻辑。1+(1+1) -> 1 + 1
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next(head);
        head.next=null;
        return newHead;
    }

    /**
     * 每次循环前，记得把下个节点先标记起来。next = current.next();
     * 指针移动的时候记得顺序，先移动pre, 再移动current. 就像你要升官得先找个人接替你位置，然后自己再升。
     * @param head
     * @return
     */
    public static ListNode<Integer> listNodeReverse3(ListNode<Integer> head) {
        ListNode<Integer> pre = null;
        ListNode<Integer> current = head;
        ListNode<Integer> next = null;
        while (current != null) {
            next = current.next();
            current.next(pre);
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * java 问题分解成，首先是实现[a,b)链表翻转，然后是将链表分成K个一组，每组调用翻转链表的函数，对于不足K个的进行特殊处理即不翻转。
     * 关键点在 head.next = reverseKGroup(mark,k); 因为反转了，所以head是末尾元素了，这时候head.next -> 下一个反转结果(每次都吐了一个新的head出来)。形成了一个循环开始。
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode mark = head;
        for(int i = 0; i < k; i++){
            if(mark == null){
                // 不足k个不需要翻转
                return head;
            }
            mark = mark.next;
        }
        ListNode newHead = reverse(head,mark);
        head.next = reverseKGroup(mark,k);
        return newHead;

    }
    public static ListNode reverse(ListNode a,ListNode b){
        // 迭代实现翻转[a,b)左闭右开
        ListNode pre,cur,next;
        pre = null;
        cur = a;
        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
