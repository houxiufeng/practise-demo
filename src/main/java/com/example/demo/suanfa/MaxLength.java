package com.example.demo.suanfa;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给一个数组，计算最大连续递增数列长度
 */
public class MaxLength {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 3, 4, 9, 5, 6, 11, 7, 5, 8, 9, 10};
        System.out.println(Arrays.stream(a).sorted().boxed().collect(Collectors.toList()));
        System.out.println(max(a));
        System.out.println(max2(a));
        System.out.println(longestConsecutive(a));

    }

    /**
     * 暴力解法，时间复杂度O(n2)
     * @param a
     * @return
     */
    public static int max(int[] a) {
        Arrays.sort(a);
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int length = 1;
            for (int j = i; j < a.length - 1; j++) {
                if (a[j + 1] - a[j]  == 1) {
                    length++;
                } else {
                    break;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }

    /**
     * 允许重复O(n)
     * @param a
     * @return
     */
    public static int max2(int[] a) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : a) {
            if (!set.contains(i - 1)) {
                int length = 1;
                while (set.contains(i + length)) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }

    /**
     * 改进上面，不允许重复. O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for(int num : nums) {
            if(!map.containsKey(num-1) || map.get(num) > 1) {
                int curLen = 1;
                while(map.containsKey(num + curLen)) {
                    boolean b = map.get(num + curLen) > 1;
                    curLen ++;
                    if (b) {
                        break;
                    }
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
