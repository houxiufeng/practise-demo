package com.example.demo.practice;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.TreeNode;

import java.util.Stack;

/**
 * 前：1 2 4 8 9 5 10 3 6 7
 * 中：8, 4, 9, 2, 10, 5, 1, 6, 3, 7
 * 后：8, 9, 4, 10, 5, 2, 6, 7, 3, 1
 */
public class BinaryTreeScanTest {
    public static void main(String[] args) {
//        Integer[] a = {1,2,3,4,5,6,7,8,9,10,11,12};
        TreeNode<String> integerTreeNode = TestUtils.buildBinaryTree("a","b","c","d","e","f","g","h","i","j","k","l","m");
        dfs(integerTreeNode);
    }

    /**
     * dfs 练手，前序遍历
     * @param root
     */
    public static void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.value());
            if (pop.right() != null) {
                stack.add(pop.right());
            }
            if (pop.left() != null) {
                stack.add(pop.left());
            }
        }
    }
}
