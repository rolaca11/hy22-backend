package com.hackyeah.hy22.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackyeah.hy22.Application;
import com.hackyeah.hy22.api.ApiToken;
import com.hackyeah.hy22.models.VersionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class VersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void versionWithAuth() throws Exception {
        MockHttpServletResponse tokenResponse = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content("username=ropi&password=ropi")).andReturn().getResponse();

        assertThat(tokenResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
        String token = objectMapper.readValue(tokenResponse.getContentAsByteArray(), ApiToken.class).getToken();

        MockHttpServletResponse response = mockMvc.perform(get("/version").header("Authorization", "Bearer " + token)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(objectMapper.readValue(response.getContentAsByteArray(), VersionResponse.class).getVersion()).isNotNull();
    }

    @Test
    void versionWithoutAuth() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/version")).andReturn().getResponse();

        assertThat(response.getStatus()).isNotEqualTo(HttpStatus.OK.value());
    }
}