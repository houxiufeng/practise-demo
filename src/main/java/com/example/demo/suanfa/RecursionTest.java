package com.example.demo.suanfa;

public class RecursionTest {

    public static void main(String[] args) {
//        System.out.println(jiecheng(6));
//        printN(123);
//        System.out.println(sumN(9));
        System.out.println(oneAdd(12345));
    }

    /**
     * 递归求 N 的阶乘
     * @param n
     * @return
     */
    public static int jiecheng(int n) {
        if (n == 1) {
            return 1;
        }
        return n * jiecheng(n - 1);
    }

    public static void printN(int n) {
        if (n == 0) {
            return;
        }
        //放在这里顺序是12345
        printN(n / 10);
        int m = n % 10;
        System.out.print(m);

        //如果放在这里顺序是54321
//        printN(n / 10);

    }

    /**
     * 1+2+3+4+5+6+7+8+9+10=55
     * @param n
     * @return
     */
    public static int sumN(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumN(n - 1);
    }

    public static int oneAdd(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + oneAdd(n / 10);
    }
}
