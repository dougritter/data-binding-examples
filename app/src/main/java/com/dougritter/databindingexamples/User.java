package com.dougritter.databindingexamples;

public class User {
    public static final String NON_DEFAULT_NAME = "José";
    public static final String NON_DEFAULT_LAST_NAME = "dos Santos";
    public static final String IS_ADULT = "Adult";
    public static final String IS_NOT_ADULT = "Not Adult";
    public static final String OBJECT_IS_NULL = "Object is null";

    private String name;
    private String lastName;
    private int age;

    public User(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}