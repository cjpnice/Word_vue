package com.cjpnice.word.entity;

import java.io.Serializable;

/**
 * @author cjpnice
 */
public class User implements Serializable {
    private Integer userId;
    private String username;
    private Integer todayIsRecite;
    private String password;
    private String email;
    private Integer wordNum;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", todayIsRecite=" + todayIsRecite +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", wordNum=" + wordNum +
                '}';
    }

    public Integer getWordNum() {
        return wordNum;
    }

    public void setWordNum(Integer wordNum) {
        this.wordNum = wordNum;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTodayIsRecite() {
        return todayIsRecite;
    }

    public void setTodayIsRecite(Integer todayIsRecite) {
        this.todayIsRecite = todayIsRecite;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
