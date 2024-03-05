package com.example.demo.practice;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.ListNode;

import java.util.LinkedList;

/**
 * K 个一组翻转链表
 * 困难
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 */
public class ListNodeRevertK {
    public static void main(String[] args) {
        System.out.println(revertKGroup(TestUtils.listNodes(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3));
        LinkedList<Integer> list = new LinkedList<>();
    }

    public static ListNode<Integer> revertKGroup(ListNode<Integer> head, int k) {
        ListNode<Integer> mark = head;
        for (int i=0; i< k; i++) {
            mark = mark.next;
            if (mark == null) {
               return head;
            }
        }
        ListNode<Integer> newHead = revert(head,mark);
        head.next = revertKGroup(mark,k);
        return newHead;
    }

    public static ListNode<Integer> revert(ListNode<Integer> head, ListNode<Integer> tail) {
        ListNode<Integer> pre = null;
        ListNode<Integer> current = head;
        ListNode<Integer> next = null;
        while (current != tail) {
            next = current.next;
            current.next(pre);
            pre = current;
            current = next;
        }
        return pre;
    }
}
