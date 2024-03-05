package com.example.demo.utils;

import com.example.demo.vo.Element;
import com.example.demo.vo.ListNode;
import com.example.demo.vo.TreeNode;
import com.sun.source.tree.BinaryTree;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TestUtils {

    private static String[] names = {"allen","bob","adam","lucy","lily","kent","elvis","fitz","jason","frank","clark","wood","leonardo","mike","bill","smith","vivian","forrest","cloud","emily","john","tylor","bin","tom","jerry","scott"};


    public static <T>TreeNode<T> buildBinaryTree(T... elements) {
        if (elements == null || elements.length == 0) {
            return null;
        }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        int i = 0;
        TreeNode<T> root = new TreeNode<>(elements[i]);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> element = queue.poll();
            if (++i < elements.length) {
                if (elements[i] != null) {
                    TreeNode<T> leftNode = new TreeNode<>(elements[i]);
                    element.left(leftNode);
                    queue.add(leftNode);
                }
            }
            if (++i < elements.length) {
                if (elements[i] != null) {
                    TreeNode<T> rightNode = new TreeNode<>(elements[i]);
                    element.right(rightNode);
                    queue.add(rightNode);
                }
            }
        }
        return root;

    }

    public static ListNode<Element> listElementNodes(Element... elements) {
        ListNode<Element> head = new ListNode<Element>(null);
        ListNode<Element> current = head;
        for (Element e : elements) {
            current = current.next(new ListNode<Element>(e));
        }
        return head.next();
    }

    public static ListNode<Element> listElementNodes(String... strings) {
        ListNode<Element> head = new ListNode<Element>(null);
        ListNode<Element> current = head;
        for (String s : strings) {
            current = current.next(new ListNode<Element>(new Element(s)));
        }
        return head.next();
    }

    public static ListNode<Integer> listNodes(Integer... integers) {
        ListNode<Integer> head = new ListNode<Integer>(null);
        ListNode<Integer> current = head;
        for (Integer i : integers) {
            current = current.next(new ListNode<Integer>(i));
        }
        return head.next();
    }

    public static ListNode<String> listNodes(String... strings) {
        ListNode<String> head = new ListNode<String>(null);
        ListNode<String> current = head;
        for (String s : strings) {
            current = current.next(new ListNode<String>(s));
        }
        return head.next();
    }
    /**
     * n个元素 m个有重复
     * @param n
     * @param m
     * @return
     */
    public static int[] intDupArray(int n, int m) {
        int[] ints = intArray(n);
        for (int i = 0; i < m; i++) {
            ints[i] = ints[n - 1 - i];
        }
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intArray(int n) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            while(!set.add(ThreadLocalRandom.current().nextInt(100)));
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intArray(int... n) {
        int[] array = new int[n.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = n[i];
        }
        return array;
    }

    public static String[] randomStringArray(int n) {
        List<String> strings = randomStringList(n);
        return strings.toArray(new String[strings.size()]);
    }
    public static List<String> randomStringList(int n) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < n ; i++) {
            if (i >= names.length) {
                list.add("mock" + i);
            } else {
                list.add(names[i]);
            }
        }
        Collections.shuffle(list);
        return list;
    }


    public static void main(String[] args) {
//        ListNode<Element> stringListNode = listElementNodes("aa", "bb", "cc");
//        System.out.println(stringListNode);
//
//        ListNode<String> listNode = listNodes("aa", "bb", "cc");
//        System.out.println(listNode);
//
//        ListNode<Element> listNode3 = listElementNodes(new Element("aa"), new Element("bb"), new Element("cc"));
//        System.out.println(listNode3);

        Integer[] ints = {1,2,3,4,5,6,7,8,9,10};
        TreeNode<Integer> integerTreeNode = buildBinaryTree(ints);
        System.out.println(integerTreeNode);

    }
}
