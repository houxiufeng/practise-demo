package com.example.demo.suanfa;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 桶排序算法。
 * 诀窍：分数作为数组的下标，存的数是有几个人得了这个分。
 * 数组初始化：int[] a = new int[5]; ==> {0,0,0,0,0}
 * 统计你分数的排名，就是统计比你分数高的分数有多少。
 */
public class ScoreRank {
    public static void main(String[] args) {
//        int[] scores  = {1,2,3,6,8,9,2,4,90,25,11,4,4,5,25,3};
        int[] scores  = {50,75,80,100,81,80};
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));
        System.out.println(scoreRank(scores, 100));
    }

    public static int scoreRank(int[] scores, int score) {
        int max = 0;
        int min = 800;
        for (int i = 0; i< scores.length; i++) {
            max = Math.max(max, scores[i]);
            min = Math.min(min, scores[i]);
        }
        int[] buckets = new int[max - min + 1];
        for (int i = 0; i < scores.length; i++) {
            buckets[scores[i] - min]++;
        }
        System.out.println(Arrays.toString(buckets));
        int result = 0;
        //统计你分数的排名，就是统计比你分数高的分数有多少。
        for (int i = score + 1 - min; i < buckets.length; i++) {
            result += buckets[i];
        }
        return result + 1;
    }
}
