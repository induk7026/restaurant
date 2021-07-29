package co.kr.restaurant.store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMenuItemRequest {

    private Long id;

    private String name;

    public MenuItem convert(Long restaurantId) {
        return MenuItem
                .builder()
                .id(this.id)
                .name(this.name)
                .restaurantId(restaurantId)
                .build();
    }

}
