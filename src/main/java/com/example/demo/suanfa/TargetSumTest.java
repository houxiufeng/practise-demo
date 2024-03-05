package com.example.demo.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/description/
 * 简单
 * 输入：target = 12
 * 输出：[[3, 4, 5]]
 * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]
 * 思路：根二叉树求和等于target差不多方法。
 */
public class TargetSumTest {
    private static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(sumList(9));
    }

    public static List<List<Integer>> sumList(int target) {
        if (target < 3) {
            return result;
        }
        for (int i = 1; i < target; i++) {
            findTargetSumWays(target, i, new ArrayList<>());
        }
        return result;
    }

    /**
     * n 表示从n开始找
     * @param target
     * @param n
     * @param list
     */
    public static void findTargetSumWays(int target, int n, List<Integer> list) {
        if (target < 0) {
            return;
        }
        target -= n;
        list.add(n);
        if (target == 0) {
            result.add(list);
            return;
        }
        findTargetSumWays(target, n + 1, new ArrayList<>(list));
    }
}
