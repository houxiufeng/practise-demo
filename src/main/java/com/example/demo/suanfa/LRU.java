package com.example.demo.suanfa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 核心点：1. 一个map存值, 一个双端队列LinkedList存key的位置。2. 新的key放在队头，采用头插法，旧的自然旧排到最后面去了。
 *
 */
public class LRU {
    private Map<Integer, Integer> map = new HashMap();
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private int capacity;


    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(int key) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
            list.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            map.put(key, value);
            list.remove(new Integer(key));
            list.addFirst(key);
        } else {
            if (list.size() >= capacity) {
                Integer oldkey = list.getLast();
                map.remove(oldkey);
                list.removeLast();
                map.put(key, value);
                list.addFirst(key);
            } else {
                map.put(key, value);
                list.addFirst(key);
            }
        }
    }

    public static void main(String[] args) {
        LRU lRUCache = new LRU(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}
