package br.com.washington.simplecicd.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import br.com.washington.simplecicd.dto.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ActionController.class)
public class ActionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ActionController actionController;

    @Test
    void shouldReturnHelloWorld() throws Exception {
        Greeting greeting = new Greeting("Hello, World! - TESTE");

        System.out.println(greeting.message());
        when(actionController.greeting(greeting.message())).thenReturn(greeting);

        mockMvc.perform(get("/api/v1/actions/greeting/" + greeting.message()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message").value("Hello, World! - TESTE"));

    }
}
