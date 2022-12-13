package com.nobrand.blogapi.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("POST /v1/post")
    public void post() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/post")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("title", "title")
                        .param("content", "APPLICATION_FORM_URLENCODED")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("ModelAttribute"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("POST /v2/post")
    public void postJson() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v2/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"title\", \"content\": \"APPLICATION_JSON\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("RequestBody"))
                .andDo(MockMvcResultHandlers.print());
    }

}