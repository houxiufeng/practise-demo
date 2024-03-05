package com.example.demo.practice;

public class Stock {

    public static int mostProfit(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                result = Math.max(result, a[j] - a[i]);
            }
        }
        return result;
    }

    public static int mostProfit2(int[] a) {
        int result = 0;
        int low = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            low = Math.min(low, a[i]);
            result = Math.max(result, a[i] - low);
        }
        return result;
    }
}
