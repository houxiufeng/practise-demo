package com.example.demo;

import com.example.demo.utils.TestUtils;
import com.example.demo.vo.Human;
import com.example.demo.vo.ListNode;
import com.example.demo.vo.Man;
import com.example.demo.vo.Woman;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestSomething {
    public static void main(String[] args) {
//        int low = 0;
//        int high = 5;
//        String format = String.format("%.3f", 5.0);
//        System.out.println(format);
//
//        System.out.println(8>>2);//1000 => 10 -------> 8 / 4 = 2
//        System.out.println(8<<2);//1000 => 100000 ---> 8 * 4 = 32
//
//        BitSet bitSet = new BitSet();
//
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(0,1);
//        list.add(0,2);
//        list.add(0,3);
//        list.add(0,4);
//        System.out.println(list);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(rand5());
//        }

//        LinkedList<Integer> resultList = new LinkedList<>();
//        resultList.addFirst(1);
//        resultList.addFirst(2);
//        resultList.addFirst(3);
//        resultList.addFirst(4);
//        System.out.println(resultList);
//
//        Deque<ListNode> stack = new ArrayDeque<ListNode>();
//        stack.add(new ListNode(1));
//        stack.add(new ListNode(2));
//        stack.add(new ListNode(3));
//        System.out.println(stack);
//        System.out.println(stack.pollLast());
//        System.out.println(stack.pollLast());
//        System.out.println(stack.pollLast());
//        String s = "abc";
//        String substring = s.substring(0);
//        String substring2 = s.substring(1);
//        String substring3 = s.substring(2);
//        String substring4 = s.substring(3);
//        System.out.println(substring);
//        System.out.println(substring2);
//        System.out.println(substring3);
//        System.out.println(substring4);
//        int[] ints = TestUtils.intArray(1, 2, 3, 4, 5);
//        int[] ints1 = Arrays.copyOfRange(TestUtils.intArray(1, 2, 3, 4, 5), 1, 2);
//        int[] ints2 = Arrays.copyOf(ints, 3);
//        int[] ints3 = Arrays.copyOfRange(ints, 1, 1 + 3);
//        System.out.println("over");
//
//        List<? extends Human> list = new ArrayList<Human>();
//        List<? extends Human> list22 = new ArrayList<Man>();
//        List<? extends Human> list33 = new ArrayList<Woman>();
//        List<? extends Number> numberArray = new ArrayList<Number>();  // Number 是 Number 类型的
//        List<? extends Number> numberArray1 = new ArrayList<Integer>(); // Integer 是 Number 的子类
//        List<? extends Number> numberArray2 = new ArrayList<Double>();  // Double 是 Number 的子类
//
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println(queue);
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.peek());
//        System.out.println(queue);
//        queue.addLast(4);
//        System.out.println(queue);
//        queue.addFirst(0);
//        System.out.println(queue);
//        queue.remove(null);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        int i = set.stream().mapToInt(Integer::valueOf).max().orElseGet(null);
        System.out.println(i);

        int[] a = new int[0];
        System.out.println(a);
    }

    /**
     * matrix: int[row][col]
     * @return
     */
    public static int[][] matrix() {
        return new int[][]{{1, 2, 3, 10}, {4, 5, 6, 11}, {7, 8, 9, 12}};
    }

    public static int rand5(){
        int n=(int)(Math.random()*5+1);
        return n;
    }


}
