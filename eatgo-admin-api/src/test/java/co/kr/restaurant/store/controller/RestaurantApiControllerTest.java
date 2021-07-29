package co.kr.restaurant.store.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class RestaurantApiControllerTest {

    @Autowired
    private RestaurantApiController restaurantApiController;

    private MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.standaloneSetup(restaurantApiController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    void getRestaurantById() throws Exception {
        mvc.perform(
            get("/api/restaurant/1"))
        .andDo(print())
        .andExpect(content().string(containsString("승환")));
    }

    @Test
    public void crateWithInvalidData() throws Exception {
        mvc.perform(
                post("/api/restaurant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\", \"address\":\"\"}"))
                .andExpect(status().isBadRequest());
    }


    @Test
    void createRestaurantTest() throws Exception {
        mvc.perform(
                post("/api/restaurant")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\" : \"승환\",\"address\":\"서울\"}"))
        .andExpect(header().string("location", "/api/restaurant/21"))
        .andExpect(content().string(containsString("승환")))
        .andExpect(status().isCreated());
    }

    @Test
    void updateRestaurantTest() throws Exception {
        mvc.perform(
                put("/api/restaurant/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\" : \"이승환\",\"address\":\"경기\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void updateRestaurantInvalidTest() throws Exception {
        mvc.perform(
                put("/api/restaurant/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\" : \"\",\"address\":\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void detailWithExisted() throws Exception {
        mvc.perform(get("/restaurant/400"))
                .andExpect(status().isNotFound());
    }
}