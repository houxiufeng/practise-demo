package com.example.demo.suanfa;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * 中等：最长回文字串
 * 思路中心扩散法: 假设这个中心从0开始一直到最末尾。向两边扩散。
 */
public class HuiWen {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = "cbbd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s1));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        /**
         * 思路中心扩散法
         */
        //我们将字符串转化为数组 避免charAt方法的调用
        char[] chars = s.toCharArray();
        //一个记录最大回文字符串的起始点  一个记录回文字符串长度
        int maxStartIndex = 0;
        //默认是1 应为只要s长度不为空，最少一个字符就为一个回文
        int maxLength = 1;
        int length = s.length();
        for (int i=0;i<length;i++){
            int left = i-1;
            int right = i+1;
            int len = 0;
            //第一种情况当前数左右两边相等，进行向外扩散  回文长度为奇数时(abcba12)
            while (left>=0 && right<=length-1 && chars[left]==chars[right]){
                len=right-left+1;
                if(len>maxLength){
                    maxLength=len;
                    maxStartIndex=left;
                }
                left--;
                right++;
            }
            //第二种情况 回文的长度为偶数时(tattarrattataa) 4
            int temp =i;//1 0    2 3
            right =i+1;
            while (temp>=0 && right<=length-1 && chars[temp]==chars[right]){
                len =right-temp+1;//2 4
                if(len>maxLength){
                    maxLength =len;
                    maxStartIndex=temp;
                }
                temp--;
                right++;
            }

        }
        if(maxLength==1){
            return String.valueOf(chars[0]);
        }
        return s.substring(maxStartIndex,maxStartIndex+maxLength);
    }
}
