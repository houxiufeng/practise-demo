package com.example.demo.practice;

import com.google.common.collect.Lists;

import java.util.*;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15, 12, 4, 6, 10};
        int[] b = {-1, 0, 1, 2, -1, -4};
        int target = 16;
//        System.out.println(twoNumbersSum2(a, target));
//        int[] ints = twoSum(a, target);
//        System.out.println(Arrays.toString(ints));
        System.out.println(twoNumbersSum4(a, target));
        System.out.println(threeSum(b));
    }

    /**
     * 暴力法
     * @param a
     * @param target
     * @return
     */
    public static List<List<Integer>> twoNumbersSum(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i =0; i<a.length-1; i++) {
            List<Integer> list = null;
            for (int j=i+1; j<a.length; j++) {
                if (a[i] + a[j] == target) {
                    list = new ArrayList<>();
                    list.add(a[i]);
                    list.add(a[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * 有重复，不推荐
     * @param a
     * @param target
     * @return
     */
    public static List<List<Integer>> twoNumbersSum2(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target - a[i]) && map.get(target - a[i]) != i) {
                result.add(Lists.newArrayList(a[i], target - a[i]));
            }
        }
        return result;
    }

    /**
     * 推荐，对比上面有个小改动，但是即去重，又提高效率。
     * @param a
     * @param target
     * @return
     */
    public static List<List<Integer>> twoNumbersSum3(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target - a[i])) {
                result.add(Lists.newArrayList(a[i], target - a[i]));
            }
            map.put(a[i], i);

        }
        return result;
    }

    public static List<List<Integer>> twoNumbersSum4(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(a);
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                result.add(Lists.newArrayList(a[left], a[right]));
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    /**
     * 三个数相加等于0
     * 重点：
     * 先排序，再双指针头尾夹击判断。
     * 转变成 a+b=-c 的问题
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0) {
            return res;
        }
        int len=nums.length;
        Arrays.sort(nums);  //第一步：先排序

        for(int i=0;i<len-2;i++){ //依次遍历每一个元素，把它作为a，在后续的元素里找b+c=-a;
            if(i>0 && nums[i]==nums[i-1]) {
                continue;     //重复元素直接跳过
            }
            //找两数之和为-a，双指针法
            int low=i+1,high=len-1;
            while(low<high){
                if(nums[low]+nums[high]==-nums[i]){ //找到了一个解
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    //已经找到了，重复的去掉
                    while(low<high && nums[low+1]==nums[low])
                        low++;
                    while(low<high && nums[high-1]==nums[high])
                        high--;
                    low++;
                    high--;
                }else if(nums[low]+nums[high]<-nums[i])
                    low++;
                else
                    high--;
            }
        }
        return res;
    }


}
