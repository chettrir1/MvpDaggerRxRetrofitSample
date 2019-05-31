package com.shiva.practice.mvp.model;

public class CakeResponseStaffContacts {
    private String role;
    private String name;
    private CakeResponseStaffContactsPhones phones;
    private String dateOfBirth;
    private int id;
    private String[] email;

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CakeResponseStaffContactsPhones getPhones() {
        return this.phones;
    }

    public void setPhones(CakeResponseStaffContactsPhones phones) {
        this.phones = phones;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getEmail() {
        return this.email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }
}
