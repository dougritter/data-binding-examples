package com.dougritter.databindingexamples;

public class User {
    public static final String NON_DEFAULT_NAME = "José";
    public static final String NON_DEFAULT_LAST_NAME = "dos Santos";

    private String name;
    private String lastName;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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
}