package co.kr.restaurant.store.controller;

import co.kr.restaurant.store.service.MenuItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class MenuItemControllerTest {

    @Autowired
    private MenuItemController menuItemController;

    private MenuItemService menuItemService;

    private MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.standaloneSetup(menuItemController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    void save() throws Exception {
        mvc.perform(post("/restaurants/1/menuItems")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[{\"name\":\"hwan\"}," +
                        "{\"name\":\"hwan\"}]"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        mvc.perform(patch("/restaurants/1/menuItems")
            .contentType(MediaType.APPLICATION_JSON)
                .content("[{\"id\":1,\"name\":\"hwan\"}," +
                        "{\"id\":2,\"name\":\"hwan\"}]"))
            .andExpect(status().isOk());

    }
}