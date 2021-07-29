package co.kr.restaurant.store.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @ManyToOne
//    @Setter
//    private Restaurant restaurant;

    private Long restaurantId;

    public void update(CreateMenuItemRequest request) {
        this.name = request.getName();
    }

}
