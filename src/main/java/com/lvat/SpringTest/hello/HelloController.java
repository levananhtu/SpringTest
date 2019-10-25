package com.lvat.SpringTest.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(path = "/hello")
    public String home() {
        return "<h1>Welcome to the home page</h1>";
    }
}