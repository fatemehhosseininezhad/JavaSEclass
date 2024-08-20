package src.tamrin04.model.da;

import src.tamrin04.model.entity.Brand;
import src.tamrin04.model.entity.Product;
import src.tamrin04.model.utils.JdbcProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class ProductDa implements DataAccess<Product>, AutoCloseable {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private JdbcProvider jdbcProvider = new JdbcProvider();


    public ProductDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Product product) throws SQLException {
        product.setId(jdbcProvider.getNextId("PRODUCT_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUCT2 VALUES(?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setInt(3, product.getCount());
        preparedStatement.setDouble(4, product.getPrice());
        preparedStatement.setString(5, product.getBrand().name());
        //preparedStatement.setInt(6, product.getOw

        preparedStatement.execute();
    }

    public void edit(Product product) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE PRODUCT2 SET NAME=?, COUNT=?, PRICE=?, BRAND=? WHERE ID=?"
        );

        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getCount());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, product.getBrand().name());
        preparedStatement.setInt(5, product.getId());
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PRODUCT2 WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Product> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PRODUCT2 ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> productList = new ArrayList<>();

        while (resultSet.next()) {
            Product product =
                   Product
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .count(resultSet.getInt("COUNT"))
                            .brand(Brand.valueOf(resultSet.getString("BRAND")))
                            .price(resultSet.getInt("PRICE"))
                            .build();
            productList.add(product);
        }
        return productList ;
    }

     @Override
     public Product findById(int id) throws Exception {
         preparedStatement = connection.prepareStatement(
                 "SELECT * FROM PRODUCT2 WHERE ID=?"
         );
         preparedStatement.setInt(1, id);
         ResultSet resultSet = preparedStatement.executeQuery();
         Product product = null;

         if (resultSet.next()) {

             product =
                     Product
                             .builder()
                             .id(resultSet.getInt("ID"))
                             .name(resultSet.getString("NAME"))
                             .brand(Brand.valueOf(resultSet.getString("Brand")))
                             .price(resultSet.getInt("price"))
                             .count(resultSet.getInt("count"))
                             .build();
         }
         return product;

     }

     @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}

