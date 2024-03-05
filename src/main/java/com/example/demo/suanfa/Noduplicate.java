package com.example.demo.suanfa;

public class Noduplicate {
    public static void main(String[] args) {
//        int[] a = {1,1,2,3,3,4,5,5,6,6};
        int[] a = {1,1,2};
        System.out.println(noDup(a));
        System.out.println(distinct(a));
    }

    public static int noDup(int[] a) {
        int n = 1;
        for (int i = 0; i< a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                n++;
            } else {
                n--;
            }
        }
        return n;
    }

    public static int distinct(int[] a) {
        int n = 1;
        for (int i = 0; i< a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                n++;
            }
        }
        return n;
    }
}
