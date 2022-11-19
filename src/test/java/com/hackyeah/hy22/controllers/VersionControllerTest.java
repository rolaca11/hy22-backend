package com.hackyeah.hy22.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackyeah.hy22.models.VersionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class VersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void version() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/version")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(objectMapper.readValue(response.getContentAsByteArray(), VersionResponse.class).getVersion()).isNotNull();
    }
}