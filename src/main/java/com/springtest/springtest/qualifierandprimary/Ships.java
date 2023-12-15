package com.springtest.springtest.qualifierandprimary;

import org.springframework.stereotype.Service;

@Service
public class Ships implements Vehicle{
    @Override
    public String displayTransportMode() {
        return "Waterways";
    }
}
