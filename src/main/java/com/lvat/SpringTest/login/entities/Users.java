package com.lvat.SpringTest.login.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")
@Table(name = "users", indexes = {@Index(unique = true, columnList = "email")})
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email")
    @Email(message = "*Please provide a valid email")
    @NotEmpty(message = "*Empty field")
    private String email;

    @Column(name = "password")
    @Min(value = 5, message = "*Password must have at least 5 characters")
    @NotEmpty(message = "*Please provide a valid password")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active")
    private Integer active;

    @OneToMany(targetEntity = UserRole.class)
    @JoinColumn(referencedColumnName = "user_id", name = "user_id")
    @JsonManagedReference
    private List<UserRole> userRoleList;

    public Users() {
    }

    public Users(Long userId, @Email(message = "*Please provide a valid email") @NotEmpty(message = "*Empty field") String email, @Min(value = 5, message = "*Password must have at least 5 characters") @NotEmpty(message = "*Please provide a valid password") String password, @NotEmpty(message = "*Please provide your name") String firstName, @NotEmpty(message = "*Please provide your last name") String lastName, Integer active) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public Users(@Email(message = "*Please provide a valid email") @NotEmpty(message = "*Empty field") String email, @Min(value = 5, message = "*Password must have at least 5 characters") @NotEmpty(message = "*Please provide a valid password") String password, @NotEmpty(message = "*Please provide your name") String firstName, @NotEmpty(message = "*Please provide your last name") String lastName, Integer active) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    @JsonIgnore
    public List<Roles> getRoles() {
        List<Roles> rolesList = new ArrayList<>();
        for (UserRole userRole :
                this.userRoleList) {
            rolesList.add(userRole.getRoles());
        }
        return rolesList;
    }
}
