package co.kr.restaurant.store.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId")
    private List<MenuItem> menuItems;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId")
    private List<MenuItem> reviews;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void update(CreateRestaurantRequest restaurantRequest) {
        this.name = restaurantRequest.getName();
        this.address = restaurantRequest.getAddress();
    }
}
