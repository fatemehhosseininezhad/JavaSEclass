package src.tamrin02.da;

import jdk.nashorn.internal.runtime.PropertyMap;
import src.tamrin02.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDa {

        private Connection connection;
        private PreparedStatement preparedStatement;


        public void connect() throws SQLException {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "javase",
                    "java123"
            );
        }

        public void save(Product product) throws Exception {
            connect();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO PRODUCT (ID,NAME,PRICE,COUNT,TOTAL) VALUES (id_SEQ.NEXTVAL,?,?,?,?)"
            );
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, String.valueOf(product.getPrice()));
            preparedStatement.setString(3, String.valueOf(product.getCount()));
            preparedStatement.setDouble(4, product.getTotal());
            preparedStatement.execute();
            close();
        }


        public void edit(Product product)throws Exception {
            connect();
            preparedStatement = connection.prepareStatement(
                    "UPDATE PRODUCT SET NAME = ?,PRICE = ?, COUNT=? TOTAL=? , WHERE ID = ?"
            );
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, String.valueOf(product.getPrice()));
            preparedStatement.setString(3, String.valueOf(product.getCount()));
            preparedStatement.setDouble(4, product.getTotal());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.execute();
            close();
        }


        public void remove(int id)throws Exception {
            connect();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM PRODUCT WHERE ID = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            close();
        }

        public List<Product> findAll()throws Exception {
            connect();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PRODUCT ORDER BY ID"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> productsList = new ArrayList<>();

            while(resultSet.next()) {
                Product product = Product
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .price(resultSet.getFloat("price"))
                        .count(resultSet.getInt("count"))
                        .total(resultSet.getFloat("total"))
                        .build();
                productsList.add(product);
            }
            close();
            return productsList;
        }

        public Product findById(int id)throws Exception {
            connect();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PRODUCT_TBL WHERE ID = ?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

           Product product = null;

            if(resultSet.next()) {
               product=Product
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .price (resultSet.getFloat("price"))
                        .count (resultSet.getInt("count"))
                       .total (resultSet.getFloat("total"))
                        .build();
            }
            close();
            return product;
        }


        public Product findByName(String name)throws Exception {
            connect();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PRODUCT WHERE NAME = ?"
            );
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            Product product= null;

            if(resultSet.next()) {
               product=Product
                        .builder()
                        .id(resultSet.getInt("id"))
                       .name(resultSet.getString("name"))
                       .price (resultSet.getFloat("price"))
                       .count (resultSet.getInt("count"))
                       .total (resultSet.getFloat("total"))
                        .build();
            }
            close();
            return product;
        }



        public void close()throws Exception{
            preparedStatement.close();
            connection.close();
        }
    }


