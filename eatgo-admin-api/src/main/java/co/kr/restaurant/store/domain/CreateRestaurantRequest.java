 package co.kr.restaurant.store.domain;

 import lombok.Data;

 import javax.validation.constraints.NotEmpty;

@Data
public class CreateRestaurantRequest {

    private Long id;

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @NotEmpty(message = "주소를 입력해주세요.")
    private String address;

    public Restaurant convert() {
        return Restaurant.builder()
                .address(this.address)
                .name(this.name)
                .build();
    }
}
