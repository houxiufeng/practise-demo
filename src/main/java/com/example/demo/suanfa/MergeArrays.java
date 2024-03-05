package com.example.demo.suanfa;

import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7,0,0,0};
        int[] b = {2,4,6};
        merge2(a, 4, b, 3);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 投机的方法，先合并再排序。
     */
    public static void merge(int[] a, int m, int[] b, int n) {
        for (int i = m; i < m + n; i++) {
            a[i] = b[i - m];
        }
        Arrays.sort(a);
    }

    /**
     * 双指针法
     * 从后面开始不会覆盖已有元素
     */
    public static void merge2(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {//这一部很关键，是技巧
            if (a[i] > b[j]) {
                a[index--] = a[i--];
            } else {
                a[index--] = b[j--];
            }
        }
        while (j >= 0) {
            a[index--] = b[j--];
        }
    }
}
