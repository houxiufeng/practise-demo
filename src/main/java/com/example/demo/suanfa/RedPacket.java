package com.example.demo.suanfa;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class RedPacket {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(redPacket(1000, 10)));
        int[] ints = redPacket(1000, 10);
        int result = 0;
        for (int anInt : ints) {
            result += anInt;
        }
        System.out.println(result);

    }

    public static int[] redPacket(int m, int n) {
        //1代表一分钱
        Random random = new Random();
        int restN = n;
        int[] assignment = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int money = random.nextInt(m / restN * 2 - 1) + 1;
            assignment[i] = money;
            m -= money;
            restN--;
        }
        assignment[n - 1] = m;
        return assignment;
    }
}
