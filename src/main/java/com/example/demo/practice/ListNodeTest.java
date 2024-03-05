package com.example.demo.practice;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.ListNode;

import java.util.List;

public class ListNodeTest {
    public static void main(String[] args) {
        ListNode<Integer> integerListNode = TestUtils.listNodes(1,  3,  5);
        ListNode<Integer> integerListNode2 = TestUtils.listNodes(0, 6);
        System.out.println(merge(integerListNode, integerListNode2));

    }

    public static ListNode<Integer> merge(ListNode<Integer> node1, ListNode<Integer> node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode<Integer> dummy = new ListNode<>(-1);
        ListNode<Integer> current = dummy;
        while (node1 != null && node2 != null) {
            if (node1.getValue() < node2.getValue()) {
                current.next(node1);
                current = current.next();
                node1 = node1.next();
            } else {
                current.next(node2);
                current = current.next();
                node2 = node2.next();
            }
        }
        if (node1 != null) {
            current.next(node1);
        } else {
            current.next(node2);
        }
        return dummy.next();
    }
}
