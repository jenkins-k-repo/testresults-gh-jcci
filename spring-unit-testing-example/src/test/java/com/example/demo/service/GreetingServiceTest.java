package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    void testGreet() {
        String result = greetingService.greet("John");
        assertEquals("Hello, John", result);
    }
}
