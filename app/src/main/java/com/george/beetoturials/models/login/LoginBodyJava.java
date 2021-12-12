package com.george.beetoturials.models.login;

public class LoginBodyJava {

    String email;
    String password;
    String fcmid;

    public LoginBodyJava(String email, String password, String fcmid) {
        this.email = email;
        this.password = password;
        this.fcmid = fcmid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFcmid() {
        return fcmid;
    }

    public void setFcmid(String fcmid) {
        this.fcmid = fcmid;
    }
}
