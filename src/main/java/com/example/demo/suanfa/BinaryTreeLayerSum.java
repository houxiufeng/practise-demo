package com.example.demo.suanfa;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.TreeNode;

import java.util.*;

public class BinaryTreeLayerSum {



    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TestUtils.buildBinaryTree(1,2,3,4,5,6,7,null,9,10,11,12,null,14,15,16);
        Map<Integer, Integer> layerSum = new HashMap<>();
//        calculate(treeNode, 0, layerSum);
        calculate2(treeNode, layerSum);
        System.out.println(layerSum);
    }

    public static void calculate(TreeNode<Integer> root, int n,  Map<Integer, Integer> layerSum) {

        layerSum.put(n, layerSum.getOrDefault(n, 0) + 1);

        if (root.left != null) {
            calculate(root.left, n + 1, layerSum);
        }
        if (root.right != null) {
            calculate(root.right, n + 1, layerSum);
        }
    }

    public static void calculate2(TreeNode<Integer> root,  Map<Integer, Integer> layerSum) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int layer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            layerSum.put(layer++, size);
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

        }
    }
}
