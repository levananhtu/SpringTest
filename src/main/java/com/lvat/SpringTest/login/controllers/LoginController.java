package com.lvat.SpringTest.login.controllers;

import com.lvat.SpringTest.login.entities.Users;
import com.lvat.SpringTest.login.services.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
//@RequestMapping(path = "/login-test")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(path = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("users",user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Users user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Users userExist = userService.findUserByEmail(user.getEmail());
        if (userExist != null) {
            bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("users", new Users());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @RequestMapping(path = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findUserByEmail(authentication.getName());
        modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}