package com.lvat.SpringTest.login.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "UserRole")
@Table(name = "user_role", indexes = {@Index(unique = true, columnList = "user_id, role_id")})
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "ur_id")
    private Long urId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonBackReference
    private Users user;

    @ManyToOne(targetEntity = Roles.class)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @JsonBackReference
    private Roles roles;

    public UserRole() {
    }

    public UserRole(Long urId, Long userId, Long roleId) {
        this.urId = urId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUrId() {
        return urId;
    }

    public void setUrId(Long urId) {
        this.urId = urId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
