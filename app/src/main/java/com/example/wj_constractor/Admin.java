package com.example.wj_constractor;

public class Admin {
    private String adminId;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private String username;
    private String password;
    private String email;

    public Admin(String adminId, String firstname, String lastname, String address, String phone, String username, String password, String email) {
        this.adminId = adminId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public Admin() {
        this.adminId = "";
        this.firstname = "";
        this.lastname = "";
        this.address = "";
        this.phone = "";
        this.username = "";
        this.password = "";
        this.email = "";
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
