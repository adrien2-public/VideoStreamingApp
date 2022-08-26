package com.example.Messages.WrapperOjects;

public class AccountWO {


    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String url;

    public AccountWO() {
    }

    public AccountWO(Long id, String firstName, String lastName, String email , String url) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.url = url;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
