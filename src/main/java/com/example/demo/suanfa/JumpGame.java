package com.example.demo.suanfa;

/**
 * 题目:给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。 判断你是否能够到达最后一个位置。
 * 总结：有关动态规划的问题，大多是让你求最值的，比如最长子序列，最小编辑距离，最长公共子串等等等。这就是规律，因为动态规划本身就是运筹学里的一种求最值的算法。
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] a = {1,3,5,2,1,0,0,2,1};
        System.out.println(canJump(a));

    }

    /**
     * 贪心算法
     * 计算每一步能获取的最大收益。通过每一步的最优解，更新全局最优解，这就是贪心
     * 类比：就像扔铅球圈地，看哪个位置能仍出界。
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int mostRightPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= mostRightPos) {
                mostRightPos = Math.max(mostRightPos, i + nums[i]);
                if (mostRightPos >= nums.length - 1) {
                    return true;
                }
            }

        }
        return false;

    }
}
