package com.springtest.springtest.qualifierandprimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nameController")
public class NameController {
    @Autowired
    Vehicle ships;

    @GetMapping
    public String displayTransportMode(){
        return ships.displayTransportMode();
    }
}
