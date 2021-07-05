package co.kr.restaurant.store.service;

import co.kr.restaurant.store.domain.CreateRestaurantRequest;
import co.kr.restaurant.store.domain.Restaurant;
import co.kr.restaurant.store.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        restaurant = Restaurant
            .builder()
            .id(1L)
            .address("서울시 중랑구")
            .name("승환")
            .build();
    }

    @Test
    public void getRestaurant() {
        // given
        given(restaurantRepository.findById(any())).willReturn(Optional.ofNullable(this.restaurant));
        // when
        Restaurant restaurant = restaurantService.findById(any());
        // then
        assertThat(restaurant.getId()).isEqualTo(1L);
        assertThat(restaurant.getAddress()).isEqualTo("서울시 중랑구");
        assertThat(restaurant.getName()).isEqualTo("승환");
    }

    @Test
    public void addRestaurant() {
        //given
        given(restaurantRepository.save(any())).willReturn(restaurant);

        //when
        Restaurant createRestaurant = restaurantService.create(this.restaurant);

        assertThat(restaurant.getId()).isEqualTo(1L);
        assertThat(createRestaurant.getAddress()).isEqualTo("서울시 중랑구");
        assertThat(createRestaurant.getName()).isEqualTo("승환");
    }


    @Test
    public void updateRestaurantTest() {
        CreateRestaurantRequest request = new CreateRestaurantRequest();
        request.setAddress("서울시 성북구");
        request.setName("승환");
        restaurant.update(request);

        assertThat(restaurant.getId()).isEqualTo(1L);
        assertThat(restaurant.getAddress()).isEqualTo("서울시 성북구");
        assertThat(restaurant.getName()).isEqualTo("승환");
    }
}