package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    void testGreetEndpoint() throws Exception {
        Mockito.when(greetingService.greet("John")).thenReturn("Hello, John");

        mockMvc.perform(get("/greet").param("name", "John"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, John"));
    }
}
