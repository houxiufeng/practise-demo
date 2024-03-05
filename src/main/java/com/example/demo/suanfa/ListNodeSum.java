package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sum-lists-lcci/description/
 * 链表求和,给定两个用链表表示的整数，每个节点包含一个数位。些数位是反向存放的，也就是个位排在链表首部。
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 */
public class ListNodeSum {
    public static void main(String[] args) {
        ListNode<Integer> head = TestUtils.listNodes(9,8,3,6,9,3);
        ListNode<Integer> head2 = TestUtils.listNodes(5,2,8,4,5);
        System.out.println(head);
//        System.out.println(listNodeReverse2(head));
        System.out.println(listNodeSum(head, head2));
        System.out.println(listNodeSum2(head, head2));
        System.out.println(listNodeSum3(head, head2));

    }

    /**
     * 跟下面类似，不过返回值需要是链表
     * @param head1
     * @param head2
     * @return
     */

    public static ListNode<Integer> listNodeSum3(ListNode<Integer> head1, ListNode<Integer> head2) {
        int up = 0;
        ListNode<Integer> dummy = new ListNode<Integer>(null);
        ListNode<Integer> current = dummy;
        while (head1 != null && head2 != null) {
            int data = head1.getValue() + head2.getValue() + up;
            up = data / 10;
            current.next(new ListNode(data % 10));
            head1 = head1.next();
            head2 = head2.next();
            current = current.next();
        }
        //这里可以认为另外一个链表剩下的每个元素都是0
        while (head1 != null) {
            int data = head1.getValue() + up;
            up = data / 10;
            current.next(new ListNode(data % 10));
            head1 = head1.next();
            current = current.next();
        }
        while (head2 != null) {
            int data = head2.getValue() + up;
            up = data / 10;
            current.next(new ListNode(data % 10));
            head2 = head2.next();
            current = current.next();
        }
        if (up != 0) {
            current.next(new ListNode(up));
        }
        return dummy.next();
    }

    /**
     * 这个方法自己想的，感觉还可以。
     * 返回值是计算出来的结果
     * 核心就是 while (head1 != null && head2 != null)
     * 注意：最后需要判断up 进位数是否为0. 不为0的话：sum += up * factor;
     * 返回值是结果
     */
    public static int listNodeSum2(ListNode<Integer> head1, ListNode<Integer> head2) {
        int factor = 1;
        int sum = 0;
        int up = 0;
        while (head1 != null && head2 != null) {
            int data = head1.getValue() + head2.getValue() + up;
            up = data / 10;
            sum += data % 10 * factor;
            head1 = head1.next();
            head2 = head2.next();
            factor = factor * 10;
        }
        //这里可以认为另外一个链表剩下的每个元素都是0
        while (head1 != null) {
            int data = head1.getValue() + up;
            up = data / 10;
            sum += data % 10 * factor;
            head1 = head1.next();
            factor = factor * 10;
        }
        while (head2 != null) {
            int data = head2.getValue() + up;
            up = data / 10;
            sum += data % 10 * factor;
            head2 = head2.next();
            factor = factor * 10;
        }
        if (up != 0) {
            sum += up * factor;
        }
        return sum;
    }



    public static int listNodeSum(ListNode<Integer> head1, ListNode<Integer> head2) {
        List<Integer> integers = extractData(head1);
        List<Integer> integers2 = extractData(head2);
        return transform(integers) + transform(integers2);
    }

    public static Integer transform(List<Integer> integers) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : integers) {
            sb.append(integer);
        }
        return Integer.parseInt(sb.toString());
    }

    public static List<Integer> extractData(ListNode<Integer> head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(0, head.getValue());
            head = head.next();
        }
        return list;
    }

    public static ListNode<Integer> listNodeReverse(ListNode<Integer> head) {
        if (head.next() == null) {
            return head;
        }
        ListNode<Integer> newHead = listNodeReverse(head.next());
        head.next().next(head);
        head.next(null);
        return newHead;
    }

    /**
     * 每次循环前，记得把下个节点先标记起来。next = current.next();
     * 指针移动的时候记得顺序，先移动pre, 再移动current. 就像你要升官得先找个人接替你位置，然后自己再升。
     * @param head
     * @return
     */
    public static ListNode<Integer> listNodeReverse2(ListNode<Integer> head) {
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

}
