package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.ListNode;

public class MergeNodeList {
    public static void main(String[] args) {
        ListNode<Integer> integerListNode = TestUtils.listNodes(1, 3, 5);
        ListNode listNode = insertNode2(integerListNode, new ListNode(5));
        System.out.println(listNode);
//        ListNode<Integer> integerListNode1 = TestUtils.listNodes(1, 3, 5);
//        ListNode<Integer> integerListNode2 = TestUtils.listNodes(6);
////        merge(integerListNode1, integerListNode2);
//        System.out.println(merge2(integerListNode1, integerListNode2));

    }

    public static void merge(ListNode<Integer> head1, ListNode<Integer> head2) {
        ListNode<Integer> current = head2;
        while (current != null) {
            head2 = current.next();
            current.next(null);
            head1 = insertNode(head1, current);
            current = head2;
        }
        System.out.println(head1);

    }

    /**
     * 链表insert重点：
     * 1.单独处理 值比 header 还小的情况 和 header为null的情况
     * 2.写条件，什么时候这个while循环可以一直往后，直到挪不动。你的next都比我小，你肯定也比我小啊。
     * @param head
     * @param node
     * @return
     */
    public static ListNode insertNode(ListNode<Integer> head, ListNode<Integer> node) {
        if (head == null || head.getValue() > node.getValue()) {
            node.next(head);
            head = node;
            return head;
        }
        ListNode<Integer> current = head;
        while (current.next() != null && current.next().getValue() < node.getValue()) {
            current = current.next();
        }
        node.next(current.next());
        current.next(node);
        return head;
    }

    public static ListNode insertNode2(ListNode<Integer> head, ListNode<Integer> node) {
        ListNode<Integer> dummy = new ListNode<Integer>(-1);
        ListNode<Integer> current = dummy;
        dummy.next(head);
        while (current.next() != null && current.next().getValue() < node.getValue()) {
            current = current.next();
        }
        node.next(current.next());
        current.next(node);
        return dummy.next();
    }

    /**
     * 推荐
     * 关键点：
     *  while(head1 != null && head2 != null) 一般有两个序列都需要轮训的时候用这个方法，很好用
     *  dummyNode   加一个好处理，最后可以dummy.next() 返回头部节点。
     *  current = current.next();
     *  head1 = head1.next();
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode merge2(ListNode<Integer> head1, ListNode<Integer> head2) {
        ListNode<Integer> dummy = new ListNode<Integer>(-1);
        ListNode<Integer> current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.getValue() < head2.getValue()) {
                current.next(head1);
                current = current.next();
                head1 = head1.next();
            } else {
                current.next(head2);
                current = current.next();
                head2 = head2.next();
            }
            if (head1 != null) {
                current.next(head1);
            } else {
                current.next(head2);
            }
        }
        return dummy.next();
    }
}
