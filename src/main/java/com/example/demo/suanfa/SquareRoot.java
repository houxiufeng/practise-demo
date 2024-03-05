package com.example.demo.suanfa;

/**
 * x的平方根
 *
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(1));
        System.out.println(squareRoot(2));
        System.out.println(squareRoot(3));
        System.out.println(squareRoot(4));
        System.out.println(squareRoot(5));
        System.out.println(squareRoot(6));
        System.out.println(squareRoot(7));
        System.out.println(squareRoot(8));
        System.out.println(squareRoot(986));


    }

    public static int squareRoot(int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            //这么写防止溢出
            int mid = low + (high - low) / 2;
            if (mid * mid == n || mid == low) {
                return mid;
            } else if (mid * mid > n) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }
}
