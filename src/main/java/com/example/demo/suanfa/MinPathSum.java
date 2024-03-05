package com.example.demo.suanfa;

/**
 * 给定一个m*n大小的非负整数矩阵，求从左上角开始到右下角结束的、经过的数字的和最小的路径。每次只能向右或者向下移动
 */
public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // 创建一个与原矩阵同样大小的dp数组，用于存储到达每个点的最小路径和
        int[][] dp = new int[m][n];

        // 初始化左上角的起点
        dp[0][0] = grid[0][0];

        // 初始化第一行，只能从左向右移动
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 初始化第一列，只能从上向下移动
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 动态规划填充dp数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达当前点的最小路径和等于当前点的值加上左边或上边点的最小路径和
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 右下角的值即为最小路径和
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Minimum path sum is: " + minPathSum(grid));
    }
}