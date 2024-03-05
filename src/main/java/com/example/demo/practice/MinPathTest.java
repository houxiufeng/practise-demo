package com.example.demo.practice;

/**
 * 经典动态规划问题。
 * 1。先准备一个和原始大小一样的矩阵。
 * 2. 初始化第一行和第一列的值每个点的值。因为边边的值都是确定的，没有操作空间。
 * 3. 双层循环，先行再列，计算每个点的值，这个值是前一个或者上一个值的最小值+原始matrix里面当前点的值。
 * 4. 注意当前点就用matrix[i][j] 来表示 i 表示行row, j表示列col
 */
public class MinPathTest {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPath(matrix));
    }

    public static int minPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        //初始化第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        //初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
