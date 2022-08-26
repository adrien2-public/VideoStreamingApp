package com.example.Registration.WrapperObjects;

public class UserWO {


    private String email;
    private String uname;

    public UserWO() {

    }

    public UserWO(String email, String uname) {
        this.email = email;
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
