package src.tamrin03.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


    @Getter
    @Setter
    @NoArgsConstructor
    @SuperBuilder

    public class Product {
        private int id;
        private String product;
        private Brand brand;
        private int count;
        private double price;



    }


