package com.example.demo.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindNextN {
    public static void main(String[] args) {
        System.out.println(findNextN(21));
        char[] a = {'1','2','3','4','5','6','7'};
        reverse(a, 2);
        System.out.println(a);
        System.out.println('3' == '3');
    }

    /**
     * 暴力法
     * @param n
     * @return
     */
    public static int findNextN(int n) {
        String ns = n + "";
        String[] split = ns.split("");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            StringBuffer item = new StringBuffer(split[i]);
            for (int j = 0; j < split.length; j++) {
                if (split[j] == split[i]) {
                    continue;
                }
                item.append(split[j]);
            }
            result.add(item.toString());
        }
        List<Integer> integerList1 = result.stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
        for (int i = 0; i < integerList1.size(); i++) {
            if (integerList1.get(i) == n && i < integerList1.size() - 1) {
                return integerList1.get(i + 1);
            }
        }
        return -1;
    }

    public static int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        //从右往左找到第一个比较小的数（从右往左第一个逆序）
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        //如果从右往左，都是升序，原数最大，没答案
        if (i < 0)
            return -1;

        //上面找到了第一个逆序a[i]，从右往左a.length - 1到i+1，必然升序，且肯定存在a[j]>a[i]
        //然后从中找到最小的大于a[i]的数a[j]，（a[i]因为右边边有序，所以从右往左第一个大于a[i]即为a[j]）
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }

        //找到a[j]，与a[i]交换，意思是i的位置放比它大的j，那么肯定比原来的数大了
        swap(a, i, j);

        //要找最小的大于原数的数，所以i位置右边要最小，因为i+1到a.length - 1升序
        //所以把 i+1到a.length - 1降序，恰好就是答案，反转右边边数即可
        reverse(a, i + 1);

        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private static void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
