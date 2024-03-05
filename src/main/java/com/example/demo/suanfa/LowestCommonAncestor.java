package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.TreeNode;

/**
 * https://cloud.tencent.com/developer/article/1875014
 * 求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从低向上的遍历方式。
 * 在回溯的过程中，必然要遍历整颗二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。
 * 要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果。
 *
 * https://www.hrwhisper.me/algorithm-lowest-common-ancestor-of-a-binary-tree/
 * 两个值都在左边，则LCA在左边
 * 两个值都在右边，则LCA在右边
 * 一个在左一个在右，则说明LCA就是当前的root节点。
 * Lowest Common Ancestor = LCA
 */
public class LowestCommonAncestor {
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
        System.out.println(lowestCommonAncestor(b1, b5, b10));

    }

    /**
     * 找到p or q 或者没找到就返回，确认他们的位置。如果这个位置左边没有，那一定在右边，如果右边没有那一定在左边。如果左右各一个，那就是当前节点本身。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode<Integer> left = lowestCommonAncestor(root.left(), p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.right(), p, q);
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        return root;
    }

}
