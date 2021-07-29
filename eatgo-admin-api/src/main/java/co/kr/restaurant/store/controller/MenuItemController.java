package co.kr.restaurant.store.controller;

import co.kr.restaurant.store.domain.CreateMenuItemRequest;
import co.kr.restaurant.store.domain.response.DataResponse;
import co.kr.restaurant.store.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/restaurants")
@RequiredArgsConstructor
@RestController
public class MenuItemController {

    private final MenuItemService menuItemService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<DataResponse> findAll(@PathVariable Long restaurantId) {
        DataResponse dataResponse = menuItemService.findAll(restaurantId);
        return ResponseEntity.ok().body(dataResponse);
    }

    @GetMapping("/{restaurantId}/{menuItem}")
    public ResponseEntity<DataResponse> read(@PathVariable Long menuItemId) {
        DataResponse dataResponse = menuItemService.findById(menuItemId);
        return ResponseEntity.ok().body(dataResponse);
    }

    @PostMapping("/{restaurantId}/menuItems")
    public ResponseEntity<DataResponse> create(@RequestBody List<CreateMenuItemRequest> request, @PathVariable Long restaurantId) {
        DataResponse dataResponse = menuItemService.save(restaurantId, request);
        return ResponseEntity.ok().body(dataResponse);
    }

    @PatchMapping("/{restaurantId}/menuItems")
    public ResponseEntity<Void> update(@RequestBody List<CreateMenuItemRequest> request, @PathVariable Long restaurantId) {
        menuItemService.update(restaurantId, request);
        return ResponseEntity.ok().build();
    }
}
