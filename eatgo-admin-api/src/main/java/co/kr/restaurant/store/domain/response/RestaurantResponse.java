package co.kr.restaurant.store.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantResponse {

    private String status;
    private String result;
    private Object data;
    private String message;
}
