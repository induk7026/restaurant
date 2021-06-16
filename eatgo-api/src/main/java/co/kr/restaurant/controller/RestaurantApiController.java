package co.kr.restaurant.controller;

import co.kr.restaurant.domain.CreateRestaurantRequest;
import co.kr.restaurant.domain.Restaurant;
import co.kr.restaurant.domain.response.RestaurantResponse;
import co.kr.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
@RestController
public class RestaurantApiController {

    private final RestaurantService restaurantService;

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody CreateRestaurantRequest restaurantRequest) throws URISyntaxException {
        Restaurant restaurant = restaurantService.create(restaurantRequest.convert());
        return ResponseEntity
                .created(new URI("/api/restaurant/" + restaurant.getId()))
                .body(restaurant);
    }
//
//    @PutMapping("/{id}")
//    public Restaurant modify(@PathVariable String id) {
//        return new Restaurant();
//    }
//
//    @DeleteMapping("/{id}")
//    public Restaurant delete(@PathVariable String id) {
//        return new Restaurant();
//    }
}
