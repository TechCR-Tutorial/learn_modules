package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserList implements Serializable {

    private String userType;
    private List<RatesUser> userList;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<RatesUser> getUserList() {
        this.userList = Optional.ofNullable(userList).orElse(new ArrayList<>());
        return userList;
    }

    public void addUser(RatesUser user) {
        getUserList().add(user);
    }

    public void setUserList(List<RatesUser> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userType='" + userType + '\'' +
                ", userList=" + userList +
                '}';
    }
}
