package com.example.Accounts.WrapperObjects;

public class LoginWO {


    private String username;
    private String password;


    public LoginWO() {
    }

    public LoginWO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
