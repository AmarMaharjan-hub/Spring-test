package com.springtest.springtest.qualifierandprimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primary")
public class PrimaryController {
    @Autowired
//    @Qualifier("planes")
    Vehicle vehicle;
    @GetMapping
    public String displayTransportMode(){
        return vehicle.displayTransportMode();
    }
}
