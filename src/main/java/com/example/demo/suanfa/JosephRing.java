package com.example.demo.suanfa;

import java.util.LinkedList;

/**
 * 约瑟夫环（约瑟夫问题）是一个数学的应用问题：已知 n 个人（以编号1，2，3…n分别表示）围坐在一张圆桌周围。从编号为 k 的人开始报数，数到 m 的那个人出圈；
 * 他的下一个人又从 1 开始报数，数到 m 的那个人又出圈；依此规律重复下去，直到剩余最后一个胜利者。
 * https://www.cxyxiaowu.com/1159.html
 * 这里的核心是： index = index % list.size(); 表示某个数字在一个环中的位置。
 */
public class JosephRing {

    public static void main(String[] args) {
        System.out.println(josephRingMethod(10, 3));
    }
    private static int josephRingMethod(int n, int m){

        //初始化一个列表
        LinkedList<Integer> list = new LinkedList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = m - 1;  //先找到第一个
        while (list.size() != 0){
            System.out.println(list);
            index = index % list.size();

            System.out.println(list.get(index) + "剔除");
            list.remove(index);

            //最后一个人
            if (list.size() == 1){
                return list.get(0);
            }
            //计算下一个索引。
            index += m - 1;
        }

        return -1;
    }
}