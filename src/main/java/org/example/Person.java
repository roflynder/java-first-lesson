package org.example;

public class Person {
    private String name;
    private int age;
    private long createdAt;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.createdAt = System.currentTimeMillis() / 1000L;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
