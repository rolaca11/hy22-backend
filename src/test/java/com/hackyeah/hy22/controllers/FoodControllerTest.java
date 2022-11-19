package com.hackyeah.hy22.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackyeah.hy22.Application;
import com.hackyeah.hy22.api.ApiFoodProduct;
import com.hackyeah.hy22.api.CreateFoodRequest;
import com.hackyeah.hy22.repositories.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FoodRepository foodRepository;

    @Test
    @WithMockUser
    void testAddFoodProduct() throws Exception {
        String request = objectMapper.writeValueAsString(CreateFoodRequest.builder()
                .productName("Tesco")
                .build());

        MockHttpServletResponse response = mockMvc.perform(post("/food")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        Long id = objectMapper.readValue(response.getContentAsByteArray(), ApiFoodProduct.class).getId();

        assertThat(foodRepository.findById(id)).isNotEmpty();
    }

    @Test
    @WithMockUser
    void testGetAllFoodProducts() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/food")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        List<ApiFoodProduct> products = objectMapper.readValue(response.getContentAsByteArray(), new TypeReference<List<ApiFoodProduct>>() {});

        assertThat(products).isNotEmpty();
    }

    @Test
    @WithMockUser
    void testGetSpecificFoodProduct() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/food/1")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        ApiFoodProduct product = objectMapper.readValue(response.getContentAsByteArray(), ApiFoodProduct.class);

        assertThat(product).isNotNull();
    }

    @Test
    @WithMockUser
    void testGetDeleteFoodProduct() throws Exception {
        MockHttpServletResponse deleteResponse = mockMvc.perform(delete("/food/1")).andReturn().getResponse();
        assertThat(deleteResponse.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());

        assertThat(foodRepository.findById(1L)).isEmpty();
    }
}
