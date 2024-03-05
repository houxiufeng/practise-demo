package com.example.demo.suanfa;

import java.util.ArrayList;
import java.util.List;

public class HappyString2 {
    private static final List<String> stringList = new ArrayList<>();
    private static String[] elements = {"a","b","c"};
    public static void main(String[] args) {
//        System.out.println(happyString(1, 3));
//        System.out.println(happyString(1, 4));
        System.out.println(happyString(3, 12));
//        System.out.println(happyString(2, 7));
//        System.out.println(happyString(10, 100));
    }

    public static String happyString(int n, int k) {

        for (int i = 0; i < elements.length; i++) {
            happy(elements[i],n);
        }
        System.out.println(stringList);
        if (k > stringList.size()) {
            return "";
        }
        return stringList.get(k-1);
    }

    public static void happy(String s, int n) {
        if (n == s.length()) {
            stringList.add(s);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (s.substring(s.length() - 1).equals(elements[i])) {
                continue;
            }
            String tmp = s + elements[i];
            happy(tmp, n);
        }

    }


}
