package com.example.demo.suanfa;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 一个数据先递增再递减，找出数组不重复的个数。不能使用额外空间，复杂度o(n)
 * 重点：
 *  1.找顶点，双指针。 2.去重。3.剩余处理。
 */
public class UpDown {
    public static void main(String[] args) {
//        int[] a = {1,1, 3,3, 5,5,5,5, 7, 9,9,9,9, 8,8, 6, 4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3, 2, 0, 0, 0, 0, 0};
//        int[] a = {98,99,98,97,96,1};
        int[] a = {1,1,1,2,92,92,98,99,98,98};
        System.out.println(Arrays.toString(a));
        System.out.println("the answer is:" + Arrays.stream(a).distinct().boxed().collect(Collectors.toList()).size());
        System.out.println(sort(a));

    }
    public static int sort(int[] a) {
        //找顶点，可能是个塬，不是个尖峰。
        int topIndex = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                topIndex = i;
                break;
            }
        }
        int left = topIndex - 1;
        //塬的最右边下一个节点
        int right = topIndex + 1;
        //找塬的最左边下一个节点
        while (left > 0 && a[topIndex] == a[left]) {
            left--;
        }

        //因为顶点已经算是一个元素了。
        int count = 1;

        while (left >= 0 && right < a.length) {
            //消除重复
            while (left - 1 >= 0 && a[left] == a[left - 1]) {
                left--;
            }
            //消除重复
            while (right + 1 < a.length && a[right] == a[right+1]) {
                right++;
            }
            if (a[left] == a[right]) {
                left--;
                right++;
            } else if (a[left] > a[right]) {
                left--;
            } else {
                right++;
            }
            count++;
        }
        //如果左边还剩一段,先加上再去重

        while (left >= 0) {
            count++;
            if (a[left] == a[left + 1]) {
                count--;
            }
            left--;
        }

        //同理右边剩一段。。。
        while (right < a.length) {
            count++;
            if (a[right] == a[right - 1]) {
                count--;
            }
            right++;
        }
        return count;
    }


    public static int findElements(int[] nums) {
        int res = 0;
        // 找到最大的数
        int maxIndex = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] < nums[i-1]) {
                maxIndex = i-1;
                break;
            }
        }
        res ++;
        // 找到左右两指针开始的位置
        int left = maxIndex -1, right = maxIndex + 1;
        while(left - 1>=0 && nums[left] == nums[maxIndex]) left --;
        while(right + 1<nums.length && nums[right] == nums[maxIndex]) right ++;
        // 开始比较
        int temp = nums[maxIndex] + 1;
        while(left >=0 && right <nums.length) {
            if(nums[left] == nums[right]) {
                if(nums[left] != temp) {
                    res ++;
                    temp = nums[left];
                }
                left -- ;
                right ++;
            }else if(nums[left] < nums[right]){
                res ++;
                right ++;
            }else {
                res ++;
                left --;
            }
        }
        return res;
    }

}
