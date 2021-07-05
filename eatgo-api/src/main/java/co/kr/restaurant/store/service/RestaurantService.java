package co.kr.restaurant.store.service;

import co.kr.restaurant.store.domain.CreateRestaurantRequest;
import co.kr.restaurant.store.domain.Restaurant;
import co.kr.restaurant.store.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public void update(CreateRestaurantRequest restaurantRequest) {
        Restaurant restaurant = findById(restaurantRequest.getId());
        restaurant.update(restaurantRequest);
    }

    public void delete(Long id) {
        findById(id);
        restaurantRepository.deleteById(id);
    }
}
