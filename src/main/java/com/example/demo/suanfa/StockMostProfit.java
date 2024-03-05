package com.example.demo.suanfa;

public class StockMostProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(mostProfit(prices));
        System.out.println(mostProfit2(prices));

    }

    /**
     * Math.max 是可以直接来用的武器
     * 这道题目最直观的想法，就是暴力，找最优间距了。
     * O(n2)
     * @param prices
     * @return
     */
    public static int mostProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(result, prices[j] - prices[i]);
            }
        }
        return result;
    }

    /**
     * 贪心算法
     * 因为股票就买卖一次，那么贪心的想法很自然就是取最左最小值，取最右最大值，那么得到的差值就是最大利润。
     * O(n)
     * @param prices
     * @return
     */
    public static int mostProfit2(int[] prices) {
        int result = 0;
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }
}
