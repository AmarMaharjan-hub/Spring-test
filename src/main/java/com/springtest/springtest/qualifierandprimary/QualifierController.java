package com.springtest.springtest.qualifierandprimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qualifier")
public class QualifierController {
    @Autowired
    @Qualifier("car")
    Vehicle vehicle;

    @GetMapping
    public String displayTransportMode(){
        return vehicle.displayTransportMode();
    }
}
