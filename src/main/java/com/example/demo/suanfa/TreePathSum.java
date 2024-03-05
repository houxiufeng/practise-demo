package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.TreeNode;

/**
 * https://leetcode.cn/problems/path-sum/description/
 * 【简单】二叉树root到叶子节点路径总和是否等于某个值
 */
public class TreePathSum {
    public static void main(String[] args) {

//        TreeNode<Integer> integerTreeNode = TestUtils.buildBinaryTree(1,2,3,4,5,6,7,8,9,10);
        TreeNode<Integer> integerTreeNode = TestUtils.buildBinaryTree(5,4,8,11,null,13,4,7,2,null,null,null,1);
        System.out.println(dfs(integerTreeNode, 22));
    }


    /**
     * dfs, 每次进来减当前值，看看哪个分之能到叶子节点后sum 减为0.
     * @param root
     * @param sum
     * @return
     */
    private static boolean dfs(TreeNode<Integer> root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.value;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
}
