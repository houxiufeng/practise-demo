package com.example.demo.suanfa;

/**
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问k[0]*k[1]*...*k[m-1]可能的最大乘积是多少？
 * 例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18。
 *
 * 动态规划问题
 * https://www.cxyxiaowu.com/21604.html
 * m个正整数之和是n, 求m个相乘最大值。（剪绳子，砍竹子）
 * 核心思想： 第一段(j) * max(剪，不剪);
 * dp[i-j] 表示剩下的如果剪结果是多少
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(cutRope(11));
        System.out.println(cutRope2(11));
    }

    /**
     * 动态规划方式
     * 核心思想： 第一段(j) * max(剪，不剪);
     * dp[i-j] 表示剩下的如果剪结果是多少
     */
    public static int cutRope(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }

    /**
     * 一个数字能否膨胀到比自己大？
     * 结果发现如果数字>=5的数字都可以膨胀。拆分成2，3。 所以思路就是>=5尽量多的拆分3出来，5以下因为不会膨胀，所以就用自己。
     * 而且<=3的需要特殊处理，因为必须切分。所以结果是n-1.
     * 贪心算法
     */
    public static int cutRope2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int i = n/3;
        return (int)Math.pow(3, i) * (n - 3*i);
    }

}
