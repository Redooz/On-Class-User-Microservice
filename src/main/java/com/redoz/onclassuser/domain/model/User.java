package com.redoz.onclassuser.domain.model;

public class User {
    private String documentNumber;
    private String name;
    private String email;
    private String lastName;
    private String telephone;
    private Role role;
    private String password;

    public User(String documentNumber, String name, String email, String lastName, String telephone, Role role, String password) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.telephone = telephone;
        this.role = role;
        this.password = password;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}