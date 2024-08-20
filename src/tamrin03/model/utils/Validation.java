package src.tamrin03.model.utils;

import java.util.regex.Pattern;

public class Validation {
    public String productNameValidator(String product) throws Exception {
        if(Pattern.matches("^[a-zA-Z\\s]{3,30}$", product)){
            return product;
        }else{
            throw new Exception("Invalid Product name");
        }
    }

    /*public String countValidator(Integer count) throws Exception {
        if(Pattern.matches("^[1-20\\s]{1,30}$", count)){
            return count;
        }else{
            throw new Exception("Invalid Count");
        }
    }

    public String priceValidator(String price) throws Exception {
        if(Pattern.matches("^[1-100000\\s]{1,30}$", price)){
            return price;
        }else{
            throw new Exception("Invalid price");
        }
    }
*/}
