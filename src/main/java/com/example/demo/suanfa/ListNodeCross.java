package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.Element;
import com.example.demo.vo.ListNode;

/**
 * 链表相交(简单)
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第 k 个节点与另一个链表的第 j 个节点是同一节点（引用完全相同），则这两个链表相交。
 */
public class ListNodeCross {
    public static void main(String[] args) {
        Element cc = new Element("cc");
        ListNode<Element> listNode1 = TestUtils.listElementNodes(new Element("aa"),new Element("bb"),cc,new Element("dd"));
        ListNode<Element> listNode2 = TestUtils.listElementNodes(new Element("ee"),new Element("ff"),new Element("gg"), new Element("hh"));

        System.out.println(cross(listNode1, listNode2));



    }

    public static boolean cross(ListNode<Element> head, ListNode<Element> head2) {
        ListNode current1 = head;
        ListNode current2 = head2;
        while (current1!= null) {
            while(current2!= null) {
                if (current2.getValue() == current1.getValue()) {
                    return true;
                }
                current2 = current2.next();
            }
            current1 = current1.next();
            current2 = head2;
        }
        return false;
    }
}
