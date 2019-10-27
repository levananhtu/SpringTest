package com.lvat.SpringTest.login.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "roles")
@Entity(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name", unique = true)
    private String roleName;

    @OneToMany(targetEntity = UserRole.class)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @JsonManagedReference
    private List<UserRole> userRoleList;

    public Roles() {
    }

    public Roles(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Roles(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    @JsonIgnore
    public List<Users> getUsers() {
        List<Users> usersList = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            usersList.add(userRole.getUser());
        }
        return usersList;
    }
}
