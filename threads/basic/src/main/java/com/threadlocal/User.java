package com.threadlocal;

import java.util.Date;

public class User {

    private String name;
    private Date birthDate;

    public User(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
