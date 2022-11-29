package com.example.jobup.domain;

import java.io.Serializable;

public class UserDomain implements Serializable {

    private String userFullName;
    private String userEmail;

    public UserDomain(String userFullName, String userEmail) {
        this.userFullName = userFullName;
        this.userEmail = userEmail;
    }

    public UserDomain() {

    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}