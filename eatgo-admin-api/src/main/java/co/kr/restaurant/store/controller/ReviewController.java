package co.kr.restaurant.store.controller;

import co.kr.restaurant.store.controller.dto.ReviewDto;
import co.kr.restaurant.store.domain.Review;
import co.kr.restaurant.store.domain.response.DataResponse;
import co.kr.restaurant.store.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("{restaurantId}/reviews")
    public ResponseEntity<DataResponse> create(@PathVariable Long restaurantId, @RequestBody ReviewDto reviewDto) {
        reviewDto.setRestaurantId(restaurantId);
        Review review = reviewService.addReview(reviewDto.convert());

        return ResponseEntity.ok().body(DataResponse.OK(review));
    }
}
