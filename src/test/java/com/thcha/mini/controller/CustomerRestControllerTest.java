package com.thcha.mini.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.transaction.annotation.Transactional;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// //import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

// import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // @Autowired
    // CustomerController customerController;

    @Test
    public void createEvent() throws Exception { 
        // Event event = new Event();
        // event.setName("");
        // event.setLimit(10);

        // String json = objectMapper.writeValueAsString(event);

        // mockMvc.perform(post("/customers")
        //         .contentType(MediaType.APPLICATION_JSON_UTF8)
        //         .content(json))
        //         .andDo(print())
        //         .andExpect(status().isOk())
        //         .andExpect(jsonPath("name").value("gramman75"))
        //         .andExpect(jsonPath("limit").value(10));
    }

}