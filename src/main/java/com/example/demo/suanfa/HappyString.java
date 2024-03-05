package com.example.demo.suanfa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
 * 这段代码定义了一个名为 HappyString 的类，其中包含了 findKthString 方法，它接受两个整数 n 和 k 作为输入，并返回第 k 个开心字符串。
 * generateHappyStrings 方法用于生成所有可能的开心字符串，而 backtrack 方法是一个递归的回溯算法，用于生成字符串。
 * 在 main 方法中，我们提供了一个示例调用，它将找到长度为 3 的第 4 个开心字符串，并打印结果。
 * 请注意，这个实现在 n 较大时可能会非常慢，因为它需要生成所有可能的字符串。对于较大的 n 和 k，可能需要更高效的算法来解决这个问题。
 */
public class HappyString {

    private static final char[] CHARS = {'a', 'b', 'c'};

    public static String findKthString(int n, int k) {
        List<String> strings = generateHappyStrings(n);
        if (strings.size() < k) {
            return "";
        }
        Collections.sort(strings);
        return strings.get(k - 1);
    }

    private static List<String> generateHappyStrings(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, int n, int depth) {
        if (depth == n) {
            result.add(current.toString());
            return;
        }

        for (char ch : CHARS) {
            if (current.length() == 0 || ch != current.charAt(current.length() - 1)) {
                current.append(ch);
                backtrack(result, current, n, depth + 1);
                current.deleteCharAt(current.length() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        int n = 3; // Length of the string
        int k = 4; // The k-th string to find
        String kthString = findKthString(n, k);
        System.out.println("The " + k + "-th happy string is: " + kthString);
    }
}
