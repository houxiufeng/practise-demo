package com.example.demo.vo;

import lombok.ToString;

@ToString
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public TreeNode<T> left() {
        return left;
    }

    public TreeNode<T> right() {
        return right;
    }

    public void left(TreeNode<T> left) {
        this.left = left;
    }

    public void right(TreeNode<T> right) {
        this.right = right;
    }
}
