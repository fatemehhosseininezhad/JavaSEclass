package src.tamrin02.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

public class Product {
    private int id;
    private String name;
    private int count ;
    private float price;
    private float total=count*price;



}



