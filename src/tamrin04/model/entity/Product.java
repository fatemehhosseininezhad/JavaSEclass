package src.tamrin04.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import src.tamrin04.model.entity.Brand;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

public class Product {
    private int id;
    private String name;
    private Brand brand;
    private int count;
    private int price;
    private int owner_id;

}


