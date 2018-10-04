package com.vengard.rentis.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Email
    private String email;

    @ManyToMany
    private List<UserRole> roles;

    @OneToMany
    private List<RentHistory> rentHistories;

    public User() {
    }

    public User(String username, String password, @Email String email, List<UserRole> roles, List<RentHistory> rentHistories) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.rentHistories = rentHistories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<RentHistory> getRentHistories() {
        return rentHistories;
    }

    public void setRentHistories(List<RentHistory> rentHistories) {
        this.rentHistories = rentHistories;
    }
}
