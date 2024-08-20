package src.tamrin03.test;

import src.tamrin03.model.da.ProductDa;

import java.sql.SQLException;

public class Producttest {
    public static void main(String[] args) throws Exception {
//        try with resource
        try(ProductDa productDa = new ProductDa()){
            productDa.save(null);
            productDa.edit(null);
            productDa.remove(0);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
