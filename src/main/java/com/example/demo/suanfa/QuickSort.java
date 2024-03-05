package com.example.demo.suanfa;

import java.util.Arrays;

/**
 * https://pdai.tech/md/algorithm/alg-sort-x-fast.html
 * 快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。
 * 快速排序是不稳定的算法：假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的！
 */
public class QuickSort {

    /**
     * 从数列中挑出一个基准值。
     * 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置。
     * 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
     */
    public static void main(String[] args) {
        int[] a = {1, 5, 3, 6, 4, 3, 7, 8, 3, 12, 11, 13};
        System.out.println("before sort");
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println("after sort");
        System.out.println(Arrays.toString(a));

    }

    /**
     * 核心点理解：
     * 递归处理逻辑相似的问题,大化小。
     * 让一个数组的左边都小于x，右边都大于x。 x为基准值，一般选数组第一个点。
     * a[i++] = a[j] 相当于 a[i] = a[j]; i++; 这里防止有重复数据
     * a[i] = a[j]理解为把a[j]这个位置的值挖出来，放在a[i]的位置上。这时a[j]就相当于一个空缺位置了。
     * 我的白话理解：因为事先把a[i]的值放入x,那么其实就相当于n个值有n+1个窟窿，多出来的一个用来运作排序。保证其他数据不会被覆盖掉。
     * @param a
     * @param left
     * @param right
     */

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int x = a[left];
        while (i < j) {
            while(i < j && x < a[j]) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while(i < j && x > a[i]) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = x;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }
}
