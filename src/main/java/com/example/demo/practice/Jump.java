package com.example.demo.practice;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Jump {
    public static void main(String[] args) {
//        int[] ints = redPackage(100, 10);
//        int sum = Arrays.stream(ints).peek(System.out::println).sum();
//        System.out.println(sum);
        int[] a = {1, 3, 5, 7,0,0,0};
        int[] b = {2,4,6};
        merge(a, 4, b, 3);
        System.out.println(Arrays.toString(a));
    }

    public static boolean jump(int[] a) {
        int farthest = 0;
        for (int i = 0; i < a.length; i++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, a[i] + i);
                if (farthest >= a.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] redPackage(int m, int n) {
        int[] result = new int[n];
        int restN = n;
        for (int i = 0; i < n - 1; i++) {
//            result[i] = ThreadLocalRandom.current().nextInt(m - (n - i - 1)) + 1;
            result[i] = ThreadLocalRandom.current().nextInt(m/restN  * 2 - 1) + 1;
            m -= result[i];
            restN--;
        }
        result[n - 1] = m;
        return result;
    }

    public static void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while(i >= 0 && j >= 0) {
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
