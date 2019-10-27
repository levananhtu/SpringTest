package com.lvat.SpringTest.login.services;

import com.lvat.SpringTest.login.entities.Roles;
import com.lvat.SpringTest.login.entities.UserRole;
import com.lvat.SpringTest.login.entities.Users;
import com.lvat.SpringTest.login.repositories.RolesRepository;
import com.lvat.SpringTest.login.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "userService")
public class UserService {
    public static final int SIZE = 20;

    private BCryptPasswordEncoder passwordEncoder;
    private RolesRepository rolesRepository;
    private UsersRepository usersRepository;

    @Autowired
    public UserService(BCryptPasswordEncoder passwordEncoder, RolesRepository rolesRepository, UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
    }

    public List<Users> findUsersByActive(Integer active, Integer page) {
        return usersRepository.findByActive(active, Users.class, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public List<Roles> findRoleByRoleName(String roleName, Integer page) {
        return rolesRepository.findByRoleName(roleName, Roles.class, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public void saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        List<Roles> rolesList = rolesRepository.findByRoleName("ADMIN", Roles.class, PageRequest.of(0, SIZE)).get().collect(Collectors.toList());
        List<UserRole> userRoleList = new LinkedList<>();
        for (Roles role : rolesList) {
            userRoleList.add(new UserRole(user.getUserId(), role.getRoleId()));
        }
        user.setUserRoleList(userRoleList);
        usersRepository.save(user);
    }

    public Users findUserByEmail(String email) {
        return usersRepository.findByEmail(email, Users.class);
    }
}
