package com.example.demo.practice;

import com.example.demo.utils.TestUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] a = TestUtils.intArray(1,3,4,9,6,8,4,2,6,3,5);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.stream(a).sorted().boxed().collect(Collectors.toList()));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i< j && a[j] > base) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < base) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = base;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

}
