package com.example.demo.suanfa;

/**
 * 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/
 * 参考：https://www.bilibili.com/video/BV1Qg411q7ia/?vd_source=a829e69232988cd1691360547865a27a
 * 每个点能接的雨水是 min(left[i], right[i]) - a[i]. 累计起来就是总共能接的雨水。
 * 关键点：新建数组左边开始单调递增的最大值保存起来，新建数组右边单挑递增的最大值保存起来。
 */
public class WaterCapacity {
    public static void main(String[] args) {
//        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] a = {4,2,0,3,2,5};
        System.out.println(calcWaterCapacity(a));

    }
    public static int calcWaterCapacity(int[] a) {
        int[] leftMax = new int[a.length];
        leftMax[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], a[i]);
        }
        int[] rightMax = new int[a.length];
        rightMax[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - a[i];
        }
        return result;
    }
}
