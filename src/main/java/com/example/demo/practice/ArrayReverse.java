package com.example.demo.practice;

import com.example.demo.utils.TestUtils;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] a = TestUtils.intArray(1,2,3,4,5,6,7,8);
//        for (int i = 0; i < a.length / 2; i++) {
//            swap(a, i, a.length - 1 - i);
//        }
        reverse(a);
        System.out.println(Arrays.toString(a));
    }

    public static void reverse(int[] a) {
        int i=0, j=a.length-1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }

    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
