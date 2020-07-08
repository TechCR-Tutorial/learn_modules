package com.model;

import java.io.Serializable;

public class RatesUser extends User implements Serializable {

    private String application;

    public RatesUser() {
    }

    public RatesUser(String name, int age, String application) {
        super(name, age);
        this.application = application;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "RatesUser{" +
                "User='" + super.toString() + '\'' +
                "application='" + application + '\'' +
                '}';
    }
}
