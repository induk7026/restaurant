package co.kr.restaurant.store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Restaurant restaurant;

}
