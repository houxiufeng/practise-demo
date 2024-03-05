package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.TreeNode;

/**
 * 给定一棵二叉树，求根节点到叶子节点的最小路径和。
 */
public class BinaryTreeMinPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(TestUtils.buildBinaryTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
//        System.out.println(minSum(TestUtils.buildBinaryTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

    }

    public static int minPathSum(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return root.value + Math.min(minPathSum(root.left), minPathSum(root.right));
        } else {
            if (root.left == null) {
                return root.value + minPathSum(root.right);
            } else {
                return root.value + minPathSum(root.left);
            }
        }
    }

    public static int minSum(TreeNode<Integer> root) {
        if(root == null)
            return 0;
        if(root.left != null && root.right != null)
            return root.value + Math.min(minSum(root.left), minSum(root.right));
        else {
            if(root.left == null)
                return root.value + minSum(root.right);
            else {
                return root.value + minSum(root.left);
            }
        }
    }
}
