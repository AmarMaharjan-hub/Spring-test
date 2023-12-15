package com.springtest.springtest.qualifierandprimary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Planes implements Vehicle{
    @Override
    public String displayTransportMode() {
        return "Airways";
    }
}
