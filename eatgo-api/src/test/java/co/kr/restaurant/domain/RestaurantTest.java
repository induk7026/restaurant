package co.kr.restaurant.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RestaurantTest {

    @Test
    void create() {
        Restaurant restaurant = Restaurant
                .builder()
                .id(2L)
                .name("승환")
                .address("서울")
                .build();
        assertThat(restaurant.getName()).isEqualTo("승환");
        assertThat(restaurant.getAddress()).isEqualTo("서울");
    }
}