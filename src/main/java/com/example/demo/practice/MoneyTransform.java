package com.example.demo.practice;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MoneyTransform {
    public static Map<Character, Integer> numberMap = new HashMap<Character, Integer>();
    public static Map<Character, Integer> unitMap = new HashMap<Character, Integer>();
    static {
        numberMap.put('零', 0);
        numberMap.put('壹', 1);
        numberMap.put('贰', 2);
        numberMap.put('叁', 3);
        numberMap.put('肆', 4);
        numberMap.put('伍', 5);
        numberMap.put('陆', 6);
        numberMap.put('柒', 7);
        numberMap.put('捌', 8);
        numberMap.put('玖', 9);
        unitMap.put('拾', 10);
        unitMap.put('佰', 100);
        unitMap.put('仟', 1000);
        unitMap.put('万', 10000);
        unitMap.put('亿', 100000000);
    }

    public static void main(String[] args) {
//        System.out.println(moneyTransform("拾玖亿肆仟陆佰叁拾伍万陆仟柒佰捌拾玖"));//46356789
//        System.out.println(zh2arbaNum("三万"));//350000
//        System.out.println(zh2arbaNum("三十万"));//350000
//        System.out.println(zh2arbaNum("三十五万"));//350000
//        String s = "拾玖亿肆仟陆佰叁拾伍万陆仟柒佰捌拾玖";
        String s = "十九亿四千六百三十五万六千七百八十九"; //1946356789
//        String s = "十九亿"; //1946356789
//        String s = "十九亿四千六百三十五万";
//        String s = "六千零一十九";
//        String s = "六千零九";
//        String s = "六千零九万";
//        String s = "六千七百八十九";
//        String s = "三十五万"; //1446356789
        int sum = 0;
        if (s.indexOf("亿") != -1) {
            sum += zh2arbaNum(s.substring(0, s.indexOf("亿"))) * 10000 * 10000;
            s = s.substring(s.indexOf("亿") + 1);
        }
        if (s.indexOf("万") != -1) {
            sum += zh2arbaNum(s.substring(0, s.indexOf("万"))) * 10000;
            s = s.substring(s.indexOf("万") + 1);
        }
        if (s.length() > 0) {
            sum += zh2arbaNum(s);
        }
        System.out.println(sum);
//        int sum = 0;
//        if (split.length == 3) {
//            sum = zh2arbaNum(split[0]) * 10000 * 10000 + zh2arbaNum(split[0]) * 10000 + zh2arbaNum(split[0]);
//        } else if (split.length == 2) {
//            sum = zh2arbaNum(split[0]) * 10000 + zh2arbaNum(split[0]);
//        } else {
//            sum = zh2arbaNum(split[0]);
//        }
//        System.out.println(sum);
    }


    /**
     * 中文数字转为阿拉伯数字
     * @param zhNumStr 中文数字
     * @return 阿拉伯数字
     */
    public static int zh2arbaNum(String zhNumStr) {
        Stack<Integer> stack = new Stack<>();
        String numStr = "零一二三四五六七八九";
        String unitStr = "十百千万";

        String[] ssArr = zhNumStr.split("");
        for (String e : ssArr) {
            int numIndex = numStr.indexOf(e);
            int unitIndex = unitStr.indexOf(e);
            if (numIndex != -1 ) {
                stack.push(numIndex);
            } else if (unitIndex != -1) {
                int unitNum = (int)Math.pow(10, unitIndex + 1);
                if (stack.isEmpty()) {
                    stack.push(unitNum);
                } else {
                    stack.push(stack.pop() * unitNum);
                }
            }
        };

        return stack.stream().mapToInt(s-> s).sum();
    }

    public static int moneyTransform(String str) {
        int sum = 0;
        int l = str.length();
        for (int i = 0; i < l; i++) {
            char c = str.charAt(i);
            if (c == '零') {
                continue;
            }
            Integer n = numberMap.get(c);
            if (i + 1 < l) {
                Integer unit = unitMap.get(str.charAt(i + 1));
                sum += n * unit;
                i++;
                if (i + 1 < l && unitMap.containsKey(str.charAt(i + 1))) {
                    sum *= unitMap.get(str.charAt(i + 1 + 1));
                    i++;
                }
            }
        }
        return sum;
    }
}
