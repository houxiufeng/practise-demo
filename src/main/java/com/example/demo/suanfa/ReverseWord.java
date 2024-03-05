package com.example.demo.suanfa;

public class ReverseWord {
    public static void main(String[] args) {
        String s = "  the   sky    is blue   ";
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String words) {
        String[] wordsArray = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = wordsArray.length - 1; i >= 0; i--) {
            String s = wordsArray[i];
            if (s.trim().length() > 0) {
                sb.append(s.trim() + " ");
            }
        }
        return sb.toString().trim();
    };
}
