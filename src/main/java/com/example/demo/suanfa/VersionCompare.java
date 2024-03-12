package com.example.demo.suanfa;

public class VersionCompare {
    public static void main(String[] args) {
        String v1 = "1.10.0";
        String v2 = "1.8.1";
        System.out.println(versionCompare(v1,v2));

    }

    public static boolean versionCompare(String v1, String v2) {
        // 如果 v1 比 v2 新，返回 true，否则返回 false
        int l1=0, r1=0, l2=0, r2=0;
        while (r1 < v1.length() && r2 < v2.length()) {
            while (r1 < v1.length() && v1.charAt(r1) != '.') {
                r1++;
            }
            while (r2 < v2.length() && v2.charAt(r2) != '.') {
                r2++;
            }
            int i = Integer.parseInt(v1.substring(l1, r1));
            int j = Integer.parseInt(v2.substring(l2, r2));
            if (i > j) {
                return true;
            } else if (i < j) {
                return false;
            }
            l1 = ++r1;
            l2 = ++r2;
        }
        return false;
    }

    public static boolean versionCompare2(String v1, String v2) {
        // 如果 v1 比 v2 新，返回 true，否则返回 false
        int length1 = v1.length();
        int length2 = v2.length();
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        while(r1 < length1 && r2 < length2) {
            while(r1 < length1 &&v1.charAt(r1) != '.') r1 ++;
            while(r2 < length2 &&v2.charAt(r2) != '.') r2 ++;
            int t1 = Integer.parseInt(v1.substring(l1, r1));
            int t2 = Integer.parseInt(v2.substring(l2, r2));
            if(t1 > t2)
                return true;
            else if(t1 < t2)
                return false;
            l1 = ++r1;
            l2 = ++r2;
        }
        return false;
    }
}
