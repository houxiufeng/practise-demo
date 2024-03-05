package com.example.demo.practice;

import com.example.demo.utils.TestUtils;

import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        int[] a = TestUtils.intArray(1,3,4,5,7,9,6,2);
        buildHeap(a);
        System.out.println(Arrays.toString(a));
    }

    public static void buildHeap(int[] a) {
        for (int i = a.length/2 - 1; i >= 0; i--) {
            adjustNode(a, i);
        }
    }

    public static void adjustNode(int[] a, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < a.length && a[left] > a[max]) {
            max = left;
        }
        if (right < a.length && a[right] > a[max]) {
            max = right;
        }
        if (max != i) {
            swap(a, max, i);
            adjustNode(a, max);
        }

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
