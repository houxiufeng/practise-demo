package com.example.demo;

public interface InterfaceTest {
    default String getFullName() {
        return getFirstName() + "." + getLastName();
    }

    String getFirstName();
    String getLastName();
}
