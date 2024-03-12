package com.example.demo.juc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTest {

    private static volatile SingleTest instance;

    private SingleTest() {}

    public static SingleTest getInstance() {
        if (instance == null) {
            synchronized (SingleTest.class) {
                if (instance == null) {
                    instance = new SingleTest();
                }
            }
        }
        return instance;
    }

    /**
     * 利用反射破坏单例
     * @param args
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingleTest instance1 = SingleTest.getInstance();
        System.out.println(instance1);
        Constructor<SingleTest> declaredConstructor = SingleTest.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        SingleTest instance2 = declaredConstructor.newInstance();
        System.out.println(instance2);

    }
}
