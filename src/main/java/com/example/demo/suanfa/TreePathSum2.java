package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-ii/description/
 * 【简单】二叉树root到叶子节点路径总和是否等于某个值，把所有可能的数列列出来。
 */
public class TreePathSum2 {
    private static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {


//        TreeNode<Integer> integerTreeNode = TestUtils.buildBinaryTree(1,2,3,4,5,6,7,8,9,10);
        TreeNode<Integer> integerTreeNode = TestUtils.buildBinaryTree(5,4,8,11,null,13,4,7,2,null,null,null,1);
        System.out.println(pathSum(integerTreeNode, 22));
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list);
        System.out.println(list2);
    }

    public static List<List<Integer>> pathSum(TreeNode<Integer> root, int sum) {
        if (root == null) {
            return result;
        }
        dfs(root, sum, new ArrayList<>());
        return result;
    }

    public static void dfs(TreeNode<Integer> root, int sum, List<Integer> list) {
        list.add(root.value);
        sum -= root.value;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(list);
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, new ArrayList<>(list));
        }
        if (root.right != null) {
            dfs(root.right, sum, new ArrayList<>(list));
        }
    }


}
