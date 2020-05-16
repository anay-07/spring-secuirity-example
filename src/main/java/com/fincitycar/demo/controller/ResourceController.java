package com.fincitycar.demo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ResourceController {


    @GetMapping("/")
    public String home(){
        return "<h1> HelloWorld</h1>";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/user")
    public String user(){
        return "<h1> User</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return null;
    }

}
