package co.kr.restaurant.store.service;

import co.kr.restaurant.store.domain.Review;
import co.kr.restaurant.store.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ReviewServiceTest {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    private Review review;

    @BeforeEach
    void setUp() {
        review = Review.builder()
                .id(1L)
                .name("hwan")
                .score(5)
                .description("정말 맛있어요")
                .build();
    }

    @Test
    void findByRestaurantId() {
        //given
//        given(reviewService.findByRestaurantId(any()))
        //when

        //then
    }

    @Test
    void addReview() {
        given(reviewService.addReview(any())).willReturn(review);
        Review review = reviewService.addReview(this.review);
        assertThat(review.getId()).isEqualTo(1L);
        assertThat(review.getName()).isEqualTo("hwan");
    }
}