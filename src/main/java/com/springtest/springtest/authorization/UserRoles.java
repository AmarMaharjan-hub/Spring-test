package com.springtest.springtest.authorization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorize")
public class UserRoles {
    @GetMapping("/all")
    public String allHome(){
        return "<h1>Welcome All User</h1>";
    }
    @GetMapping("/user")
    public String userHome(){
        return "<h1>Welcome logged in user</h1>";
    }
    @GetMapping("/admin")
    public String adminHome(){
        return "<h1>Welcome Admin</h1>";
    }
}
