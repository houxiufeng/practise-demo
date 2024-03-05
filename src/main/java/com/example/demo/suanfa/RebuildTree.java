package com.example.demo.suanfa;

import com.example.demo.vo.TreeNode;

/**
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/description/
 * 【中等】复原二叉树
 *  知道先序遍历和中序遍历。请根据 preorder 和 inorder 的提示构造出这棵二叉树并返回其根节点
 * 知识点：
 *  中序遍历：root节点左边的元素全在左子树，右边的全在右子树
 *  前序遍历：第一个元素一定是root节点
 */
public class RebuildTree {
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode<Integer> root = buildTree(preOrder, inOrder);
        System.out.println(root);

    }

    public static TreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * 技巧点：
     *  1. 计算中序遍历root节点的index. 这样可以知道 left 有几个元素，right 有几个元素。
     *  2. 根据计算出来的index, 可以推到出前序遍历中左子树的元素区间和右子树的区间。因为root->left->right这样的顺序排列的。root后紧跟的就是Left节点的区间，完后又紧跟着right区间。并且呢，每个left/right区间也满足先序遍历.
     * @return
     */
    public static TreeNode<Integer> buildTree(int[] preOrder, int preBegin, int preEnd, int[] inOrder, int inBegin, int inEnd) {
        if (preBegin > preEnd) {
            return null;
        }
        int rootVal = preOrder[preBegin];
        int rootIndex = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int left = rootIndex - inBegin;
        TreeNode<Integer> root = new TreeNode<>(rootVal);
        root.left = buildTree(preOrder, preBegin + 1, preBegin + left, inOrder, inBegin, rootIndex - 1);
        root.right = buildTree(preOrder, preBegin + 1 + left, preEnd, inOrder, rootIndex + 1, inEnd);
        return root;
    }
}
