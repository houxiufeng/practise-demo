package com.example.demo.suanfa;

import java.util.Arrays;

/**
 * 给定一个数组，需要进行判断：如果从中删掉一个数字，能否在升序排序后使相邻数字的差值都是1
 */
public class DeleteNumSort {
    public static void main(String[] args) {
        int[] a = {2,3,4,5,6,7,8,9,10,11,13};
//        int[] a = {1,4,9};
        System.out.println(isOk(a));

    }

    public static boolean isOk(int[] a) {
        if (a == null) {
            return false;
        }
        if (a.length < 3) {
            return false;
        }
        Arrays.sort(a);
        int count = 0;
        if (a[1] - a[0] > 1) {
            count++;
        }
        if (a[a.length - 1] - a[a.length - 2] > 1) {
            count++;
        }

        //下标的差值和数组的差值一样说明每个元素递增，并且差值为1.
        if(a[a.length - 2] - a[1] != a.length - 2 - 1) {
            count++;
        }
        return count <= 1;
    }
}
