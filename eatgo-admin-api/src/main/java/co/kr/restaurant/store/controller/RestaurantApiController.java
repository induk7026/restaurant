package co.kr.restaurant.store.controller;

import co.kr.restaurant.store.domain.CreateRestaurantRequest;
import co.kr.restaurant.store.domain.Restaurant;
import co.kr.restaurant.store.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Restaurant> create(@Valid @RequestBody CreateRestaurantRequest restaurantRequest) throws URISyntaxException {
        Restaurant restaurant = restaurantService.create(restaurantRequest.convert());
        return ResponseEntity
                .created(new URI("/api/restaurant/" + restaurant.getId()))
                .body(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Validated @RequestBody CreateRestaurantRequest restaurantRequest) {
        restaurantRequest.setId(id);
        restaurantService.update(restaurantRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public Restaurant delete(@PathVariable Long id) {
        restaurantService.delete(id);
        return new Restaurant();
    }
}
