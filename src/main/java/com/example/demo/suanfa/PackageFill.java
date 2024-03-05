package com.example.demo.suanfa;

public class PackageFill {
    public static void main(String[] args) {
        int fill = fill(47, 8 , 10);
        System.out.println(fill);
    }

    public static int fill(int items, int availableBig, int availableSmall) {
        if (items < 5) {
            return items;
        }
        int bigCount = 0;
        int smallCount = 0;
        while (items >= 5 && availableBig != 0) {
            items -= 5;
            availableBig--;
            bigCount++;
        }
        if (items > availableSmall) {
            throw new UnsupportedOperationException("Too many items");
        }
        if (items > 0) {
            smallCount = items;
        }
        return bigCount + smallCount;
    }
}
