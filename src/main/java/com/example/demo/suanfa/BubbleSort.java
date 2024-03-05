package com.example.demo.suanfa;

import java.util.Arrays;

/**
 * https://pdai.tech/md/algorithm/alg-sort-x-bubble.html
 * 冒泡排序的时间复杂度是O(N2)。 假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢? N-1次！因此，冒泡排序的时间复杂度是O(N2)。
 * 冒泡排序是稳定的算法，它满足稳定算法的定义
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 3, 6, 4, 3, 7, 8, 3, 12, 11, 13};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 最大的数据放在末尾
     * @param a
     */
    private static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int x = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = x;
                }
            }
        }
    }
}
