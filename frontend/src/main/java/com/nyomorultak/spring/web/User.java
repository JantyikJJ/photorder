package com.nyomorultak.spring.web;


import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private Boolean isStaff;
    private String password;

    public User() { }
    public User(String name, String password, Boolean isStaff) {
        this.name = name;
        this.password = password;
        this.isStaff = isStaff;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + name + '\'' +
                ", isStaff=" + isStaff +
                ", password=" + password +
                '}';
    }
}
