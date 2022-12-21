package com.nobrand.blogapi.controller;

import com.nobrand.blogapi.repository.PostRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void clean() {
        postRepository.deleteAll();
    }

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
                .andExpect(MockMvcResultMatchers.content().string("{}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(1)
    @DisplayName("POST /v2/post")
    public void postJson() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v2/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"title\", \"content\": \"APPLICATION_JSON\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(2)
    @DisplayName("POST /v2/post : validation")
    public void postValidation() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v2/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": null, \"content\": \"APPLICATION_JSON\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(3)
    @DisplayName("POST /v2/post : data persistence")
    public void postPersistence() throws Exception {
        // when
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v2/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"title\", \"content\": \"APPLICATION_JSON\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        // then
        assertEquals(1L, postRepository.count());
    }

}