package src.tamrin04.model.utils;

import java.util.regex.Pattern;

public class Validation {
    public String productNameValidator(String product) throws Exception {
        if (Pattern.matches("^[a-zA-Z\\s]{3,30}$", product)) {
            return product;
        } else {
            throw new Exception("Invalid Product name");
        }
    }
    //todo: complete
}