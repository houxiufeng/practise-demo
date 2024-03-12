package com.example.demo.suanfa;

public class MissPositive {

    public static void main(String[] args) {
        int[] a = {1,2,0};
        int[] b = {3,4,-1, 1};
        int[] c = {7,8,9,11,12};
//        System.out.println(firstMissingPositive(a));
//        System.out.println(firstMissingPositive(b));
        System.out.println(firstMissingPositive(c));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
