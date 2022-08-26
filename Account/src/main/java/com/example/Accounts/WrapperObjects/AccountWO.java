package com.example.Accounts.WrapperObjects;



public class AccountWO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String url;

    public AccountWO() {
    }

    public AccountWO(Long id, String firstName, String lastName, String username , String url) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.url = url;
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
