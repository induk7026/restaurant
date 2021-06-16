package co.kr.restaurant.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RestaurantApiControllerTest {


    @Autowired
    private RestaurantApiController restaurantApiController;

    private MockMvc mvc;

    @BeforeEach
    void setup() {

    }

    @Test
    void getRestaurantById() throws Exception {
        mvc.perform(
                get("/api/restaurant/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("승환")));
    }

    @Test
    void createRestaurantTest() throws Exception {
        mvc.perform(
                post("/api/restaurant")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\" : \"승환\",\"address\":\"서울\"}"))
        .andExpect(content().string(containsString("승환")));

    }
}