package com.example.demo.practice;

import com.example.demo.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前：1 2 4 8 9 5 10 3 6 7
 * 中：8, 4, 9, 2, 10, 5, 1, 6, 3, 7
 * 后：8, 9, 4, 10, 5, 2, 6, 7, 3, 1
 */
public class BtreeScan {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode<Integer> b1 = new TreeNode<Integer>(1);
        TreeNode<Integer> b2 = new TreeNode<Integer>(2);
        TreeNode<Integer> b3 = new TreeNode<Integer>(3);
        TreeNode<Integer> b4 = new TreeNode<Integer>(4);
        TreeNode<Integer> b5 = new TreeNode<Integer>(5);
        TreeNode<Integer> b6 = new TreeNode<Integer>(6);
        TreeNode<Integer> b7 = new TreeNode<Integer>(7);
        TreeNode<Integer> b8 = new TreeNode<Integer>(8);
        TreeNode<Integer> b9 = new TreeNode<Integer>(9);
        TreeNode<Integer> b10 = new TreeNode<Integer>(10);
        b1.left(b2);
        b1.right(b3);
        b2.left(b4);
        b2.right(b5);
        b3.left(b6);
        b3.right(b7);
        b4.left(b8);
        b4.right(b9);
        b5.left(b10);
//        preScan1(b1);
//        System.out.println(list);
        System.out.println(preScan(b1));
        System.out.println(postScan(b1));
    }

    public static void preScan1(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
//        System.out.println(root.value);
        list.add(root.value);
        preScan1(root.left);
        preScan1(root.right);
    }

    public static List<Integer> preScan(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> cur = stack.pop();
            result.add(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }

    public static List<Integer> postScan(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            result.add(0, cur.value);
        }
        return result;
    }
}
