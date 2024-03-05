package com.example.demo.practice;

import com.example.demo.utils.TestUtils;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] a = TestUtils.intArray(1,2,3,4,5,6,7,8);
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }
}
