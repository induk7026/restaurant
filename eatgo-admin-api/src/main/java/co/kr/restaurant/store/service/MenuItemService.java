package co.kr.restaurant.store.service;

import co.kr.restaurant.store.domain.CreateMenuItemRequest;
import co.kr.restaurant.store.domain.MenuItem;
import co.kr.restaurant.store.domain.response.DataResponse;
import co.kr.restaurant.store.error.domain.NotFoundException;
import co.kr.restaurant.store.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantService restaurantService;

    public DataResponse findById(Long menuItemId) {
        MenuItem menuItem = menuItemRepository
                .findById(menuItemId)
                .orElseThrow( () -> new NotFoundException("데이터가 존재하지 않습니다."));
        return DataResponse.OK(menuItem);
    }

    public DataResponse findAll(Long id) {
        List<MenuItem> menuItem = menuItemRepository
                .findByRestaurantId(id);
        return DataResponse.OK(menuItem);
    }

    public void update(Long restaurantId, List<CreateMenuItemRequest> menuItems) {
        List<MenuItem> newMenuItems = menuItems
                .stream()
                .map(dto -> MenuItem
                    .builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .restaurantId(restaurantId)
                .build()).collect(Collectors.toList());
        menuItemRepository.saveAll(newMenuItems);
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public DataResponse save(Long restaurantId, List<CreateMenuItemRequest> request) {

        List<MenuItem> menuItems = menuItemRepository
                .saveAll(request
                        .stream()
                        .map(dto -> dto.convert(restaurantId))
                        .collect(Collectors.toList())
                );
        return DataResponse.OK(menuItems);
    }
}
