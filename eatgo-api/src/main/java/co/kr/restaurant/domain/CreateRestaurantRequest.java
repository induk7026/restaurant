package co.kr.restaurant.domain;

import lombok.Data;

@Data
public class CreateRestaurantRequest {

    private Long id;
    private String name;
    private String address;

    public Restaurant convert() {
        return Restaurant.builder()
                .address(this.address)
                .name(this.name)
                .build();
    }
}
