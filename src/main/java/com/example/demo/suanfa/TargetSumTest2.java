package com.example.demo.suanfa;

import java.util.*;

/**
 * 数组里面找最接近 target 的连续子数组。
 */
public class TargetSumTest2 {
    private static Map<Integer, List<Integer>> result = new HashMap<>();
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 10, 4, 5, 6, 11, 7, 8, 9, 12};
        int target = 60;
        List<Integer> list = sumList(a, target);
        System.out.println(list);
    }

    public static List<Integer> sumList(Integer[] a, int target) {

        findTargetSumNearestWays(target, a);
        Set<Integer> integers = result.keySet();
        if (result.isEmpty()) {
            return Arrays.asList(a);
        }
        int maxKey = integers.stream().mapToInt(Integer::valueOf).max().orElseGet(null);
        return result.get(maxKey);
    }

    /**
     * n 表示从n开始找
     * @param target
     * @param n
     */
    public static void findTargetSumNearestWays(int target, Integer[] n) {
        if (target < 0) {
            return;
        }

        for (int i = 0; i < n.length; i++) {
            int temp = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < n.length; j++) {
                temp += n[j];
                if (temp == target) {
                    list.add(n[j]);
                    result.put(temp, list);
                    break;
                } else if (temp < target) {
                    list.add(n[j]);
                } else {
                    result.put(temp - n[j], list);
                    break;
                }
            }
        }
    }
}
