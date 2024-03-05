package com.example.demo.suanfa;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * [中等]螺旋打印
 * 重点：
 *  设置好围栏左右上下l=0,r=n-1,u=0,d=n-1;
 *  构造n*n矩阵
 *  打印的时候从上面开始
 */
public class Matrix {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateMatrix(4)));
        int[][] matrix = generateMatrix2(5);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * [1, 2, 3, 4]
     * [12, 13, 14, 5]
     * [11, 16, 15, 6]
     * [10, 9, 8, 7]
     * @param n
     * @return
     */
    public static int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, u = 0, d = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int i = l; i <= r; i++) {
                matrix[u][i] = num++;
            }
            u++;
            for (int i = u; i <= d; i++) {
                matrix[i][r] = num++;
            }
            r--;
            for (int i = r; i >=l; i--) {
                matrix[d][i] = num++;
            }
            d--;
            for (int i = d; i>=u; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }


    /**
     * 正常顺序
     * [1, 2, 3, 4]
     * [5, 6, 7, 8]
     * [9, 10, 11, 12]
     * [13, 14, 15, 16]
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i * n + j + 1;
            }
        }
        return matrix;
    }
}
