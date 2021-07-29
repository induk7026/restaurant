package co.kr.restaurant.store.service;

import co.kr.restaurant.store.domain.Review;
import co.kr.restaurant.store.domain.response.DataResponse;
import co.kr.restaurant.store.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public DataResponse findByRestaurantId(Long restaurantId) {
        List<Review> list = reviewRepository.findAllByRestaurantId(restaurantId);
        return DataResponse.OK(list);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
