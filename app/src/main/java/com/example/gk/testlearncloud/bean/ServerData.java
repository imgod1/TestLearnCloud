package com.example.gk.testlearncloud.bean;

import java.io.Serializable;

/**
 * 项目名称：TestLearnCloud
 * 类描述：
 * 创建人：gk
 * 创建时间：2016/9/10 16:59
 * 修改人：gk
 * 修改时间：2016/9/10 16:59
 * 修改备注：
 */
public class ServerData {

    /**
     * age : 20
     * foo : bar
     * name : imgod
     * sex : 男
     */

    private int age;
    private String foo;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ServerData{" +
                "age=" + age +
                ", foo='" + foo + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
