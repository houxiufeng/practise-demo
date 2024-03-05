package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 * 二叉树中的最大路径和
 */
public class BinaryTreePathSumBest {
    private static int max = Integer.MIN_VALUE;
    private static int maximum = Integer.MIN_VALUE;
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
        pathSum(b1);
        System.out.println(max);
        TreeNode<Integer> s1 = TestUtils.buildBinaryTree(-10,9,20,0,0,15,7);
//        System.out.println(maxPathSum(b1));

    }

    public static int pathSum(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(pathSum(root.left()), 0);
        int right = Math.max(pathSum(root.right()), 0);
        max = Math.max(max, left + right + root.value());
        return root.value() + Math.max(left, right);
    }

//    public static int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        helper(root);
//
//        return maximum;
//    }
//
//    private static int helper(TreeNode<Integer> root) {
//        if (root == null) {
//            return 0;
//        }
//        // 如果左右子树返回的最大路径值小于 0
//        // 直接将值设为 0，也就是不考虑对应的路径
//        int leftMax = Math.max(0, helper(root.left));
//        int rightMax = Math.max(0, helper(root.right));
//        //自底向上的分治,直到到了最底层，才开始计算并返回答案
//        maximum = Math.max(root.value + leftMax + rightMax, maximum);
//
//        return Math.max(leftMax + root.value, rightMax + root.value);
//    }
}
