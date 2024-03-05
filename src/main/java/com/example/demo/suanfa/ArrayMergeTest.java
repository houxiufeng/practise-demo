package com.example.demo.suanfa;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-intervals/description/
 * [中等]合并区间
 * 二维数组不要怕，记得行列，画出来，然后写核心逻辑。
 * 可以想像成第一行是数组，第二行是数组，第三行。。。
 * 不要把里面的元素值和元素下标搞混了。
 */
public class ArrayMergeTest {
    public static void main(String[] args) {
        int[] a = {1,3};
        int[] a2 = {2,4};
        int[] a3 = {5,8};
        int[] a4 = {6,7};
        int[] a5 = {9,13};
        int[][] aa = new int[][]{a,a2,a3,a4,a5};
//        Arrays.sort(a, (x, y) -> y - x);
        int[][] merge = merge(aa);
        System.out.println(Arrays.toString(merge));

    }

    public static int[][] merge(int[][] array) {
        Arrays.sort(array, (a, b) -> a[0] - b[0]);
        int[][] result = new int[array.length][2];
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            int[] current = array[i];
            if (index == -1 || current[0] > array[i-1][1]) {
                index++;
                result[index] = current;
            } else {
                result[index][1] =  Math.max(current[1], array[i - 1][1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
