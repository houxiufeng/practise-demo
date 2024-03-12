package com.example.demo.practice;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidCharacter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1_afs");
        list.add("2_sdf");
        list.add("3_asdf");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.removeIf(item -> item.matches("\\d+_\\w+"));
        System.out.println(list);
    }
}
