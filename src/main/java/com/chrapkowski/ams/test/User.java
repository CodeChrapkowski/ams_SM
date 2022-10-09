package com.chrapkowski.ams.test;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class User {


    @Size(min = 3)
    private String name;

    @Min(value = 18)
    private int age;

    public User() {

    }

    public User(@Size(min = 3) String name, @Min(value = 18) int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
