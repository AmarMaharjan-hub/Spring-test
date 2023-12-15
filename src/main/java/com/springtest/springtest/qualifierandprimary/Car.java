package com.springtest.springtest.qualifierandprimary;

import org.springframework.stereotype.Service;

@Service
public class Car implements Vehicle{

    @Override
    public String displayTransportMode() {
        return "Roads";
    }
}
