package com.example.Accounts.WrapperObjects;

public class LoginResponseWO {



    private long id;
    private String name;
    private String username;
    private String password;


    public LoginResponseWO() {
    }

    public LoginResponseWO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginResponseWO(long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
