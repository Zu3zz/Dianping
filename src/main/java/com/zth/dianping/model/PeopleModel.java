package com.zth.dianping.model;

import java.io.Serializable;

/**
 * Date: 2020/6/18 3:27 下午
 *
 * @author 3zZ.
 */
public class PeopleModel implements Serializable {

    private static final long serialVersionUID = 278512238866331548L;
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "PeopleModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
