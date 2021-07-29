package co.kr.restaurant.store.controller.dto;

import co.kr.restaurant.store.domain.MenuItem;
import co.kr.restaurant.store.domain.Restaurant;
import lombok.Builder;
import lombok.Getter;

public class MenuItemDto {

    @Getter
    public static class Response {
        private Long id;
        private String name;
        private Long restaurantId;

        public Response(MenuItem menuItem) {
            this.id = menuItem.getId();
            this.name = menuItem.getName();
            this.restaurantId = menuItem.getRestaurantId();
        }
    }

    @Getter
    public static class Create {
        private Long id;
        private String name;
//        private Restaurant restaurant;

        @Builder
        public Create(String name, Restaurant restaurant) {
            this.name = name;
//            this.restaurant = restaurant;
        }
    }
}
