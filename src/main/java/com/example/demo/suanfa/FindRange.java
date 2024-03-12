package com.example.demo.suanfa;

import java.util.Arrays;

public class FindRange {
    public static void main(String[] args) {
//        int[] a = {5,7,7,8,8,10};
        int[] a = {};
        int target = 0;
        int[] range = findRange(a, target);
        System.out.println(Arrays.toString(range));

    }

    public static int[] findRange(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            while (i < j && a[j] > target) {
                j--;
            }
            while (i < j && a[i] < target) {
                i++;
            }
            if (i < j) {
                return new int[]{i, j};
            }

        }
        return new int[] {-1, -1};
    }

    public static int[] findRange2(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (a[mid] < target) {
                i = mid + 1;
            } else if (a[mid] > target) {
                j = mid - 1;
            } else {
                while (a[j] > a[mid]) {
                   j--;
                }
                while (a[i] < a[mid]) {
                    i++;
                }
                return new int[]{i, j};
            }

        }
        return new int[] {-1, -1};
    }
}
