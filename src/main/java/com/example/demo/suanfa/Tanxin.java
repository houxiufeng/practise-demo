package com.example.demo.suanfa;

import java.util.Arrays;

/**
 * 贪心算法：贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法策略。
 * 例子:找零问题。
 */
public class Tanxin {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100};
        System.out.println(Arrays.toString(tanxin(886, coins)));

    }

    public static int[] tanxin(int amount, int[] coins) {
        int[] result = new int[coins.length];
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                result[i]++;
            }
            if (amount == 0) {
                break;
            }
        }
        if (amount != 0) {
            throw new IllegalArgumentException("invalid coins: " + Arrays.toString(coins));
        }
        return result;
    }
}
