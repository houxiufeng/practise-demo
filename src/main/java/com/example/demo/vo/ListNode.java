package com.example.demo.vo;

import lombok.Data;

@Data
public class ListNode<T> {
    public T value;
    public ListNode<T> next;
    public ListNode(T value) {
        this.value = value;
    }
    public ListNode<T> next() {
        return next;
    }

    public ListNode next(ListNode<T> listNode) {
        this.next = listNode;
        return listNode;
    }

    @Override
    public String toString() {
        return print(this);
    }

    private String print(ListNode<T> current) {
        if (current.next == null) {
            return current.value+"";
        }
        return current.value + "-->" + print(current.next);
    }
}
