package com.example.demo.suanfa;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&amp;mid=2247484731&amp;idx=1&amp;sn=f1db6dee2c8e70c42240aead9fd224e6&amp;chksm=9bd7fb33aca07225bee0b23a911c30295e0b90f393af75eca377caa4598ffb203549e1768336&amp;scene=21#wechat_redirect
     * 千万不要看不起暴力解，动态规划问题最困难的就是写出状态转移方程，即这个暴力解。
     * 优化方法无非是用备忘录或者 DP table，再无奥妙可言。
     */
    public static int fib(int n) {
        if (n <= 0) {
            return -1;
        }
        //dp[0]空着不用
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
