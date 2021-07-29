package co.kr.restaurant.store.controller.dto;

import co.kr.restaurant.store.domain.Review;
import lombok.Data;
import lombok.Setter;

@Data
public class ReviewDto {

    @Setter
    private Long restaurantId;
    private String name;
    private int score;
    private String description;

    public Review convert() {
        return Review.builder()
                .restaurantId(restaurantId)
                .name(name)
                .score(score)
                .description(description)
                .build();
    }
}
