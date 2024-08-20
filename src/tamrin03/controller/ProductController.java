package src.tamrin03.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import src.tamrin03.model.entity.Brand;
import src.tamrin03.model.entity.Product;
import src.tamrin03.model.da.ProductDa;
import src.tamrin03.model.utils.Validation;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    private Validation validation = new Validation();


    @FXML
    private TextField idTxt, productTxt, priceTxt, countTxt;
    @FXML
    private Button saveBtn, editBtn, removeBtn;
    @FXML
    private ComboBox<String> brandCmb;
    @FXML
    private TableView<Product> productTbl;
    @FXML
    private TableColumn<Product, Integer> idCol, countCol;
    @FXML
    private TableColumn<Product, String> productCol;
    @FXML
    private TableColumn<Product, Double> priceCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Brand brand : Brand.values()) {
            brandCmb.getItems().add(brand.toString());
        }


        saveBtn.setOnAction(event -> {
            System.out.println(idTxt.getText());
            System.out.println(productTxt.getText());
            System.out.println(priceTxt.getText());
            System.out.println(countTxt.getText());
            System.out.println(brandCmb.getSelectionModel().getSelectedItem());
            resetForm();
        });

        saveBtn.setOnAction(event -> {
            try (ProductDa productDa = new ProductDa()) {
                Product product =
                        Product
                                .builder()
                                .product(validation.productNameValidator(productTxt.getText()))
                                .brand(Brand.valueOf(brandCmb.getSelectionModel().getSelectedItem()))
                                .count(Integer.parseInt(countTxt.getText()))
                                .price(Double.parseDouble(priceTxt.getText()))
                                .build();
                productDa.save(product);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Person Saved\n" + product.toString());
                alert.show();
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Person Save Error\n" + e.getMessage());
                alert.show();
            }
        });
        editBtn.setOnAction(event -> {
            try (ProductDa productDa = new ProductDa()) {
                // Data Validation
                Product product =
                        Product
                                .builder()
                                .id(Integer.parseInt(idTxt.getText()))
                                .product(validation.productNameValidator(productTxt.getText()))
                                .brand(Brand.valueOf(brandCmb.getSelectionModel().getSelectedItem()))
                                .price(Double.parseDouble(priceTxt.getText()))
                                .count(Integer.parseInt(countTxt.getText()))
                                .build();
                productDa.edit(product);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product Edited\n" + product);
                alert.show();
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Product Edit Error\n" + e.getMessage());
                alert.show();
            }
        });
        removeBtn.setOnAction(event -> {
            try (ProductDa productDa = new ProductDa()) {
                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To Remove Product ?");
                if (confirmAlert.showAndWait().get() == ButtonType.OK) {
                    int id = Integer.parseInt(idTxt.getText());
                    productDa.remove(id);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product Removed With ID : " + id);
                    alert.show();
                    resetForm();
                }

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Product Remove Error\n" + e.getMessage());
                alert.show();
            }
        });


        productTbl.setOnMouseReleased(event -> {
            Product product = productTbl.getSelectionModel().getSelectedItem();
            idTxt.setText(String.valueOf(product.getId()));
            productTxt.setText(product.getProduct());
            brandCmb.getSelectionModel().select(product.getBrand().name());
            priceTxt.setText(String.valueOf(product.getPrice()));
            countTxt.setText(String.valueOf(product.getCount()));
        });

        }
        private void resetForm () {
            idTxt.clear();
            productTxt.clear();
            priceTxt.clear();
            countTxt.clear();
            brandCmb.getSelectionModel().select(0);

            try (ProductDa productDa = new ProductDa()) {
                refreshTable(productDa.findAll());
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Find products Error\n" + e.getMessage());
                alert.show();
            }

    } private void refreshTable(List<Product> productList) {
        ObservableList<Product> products = FXCollections.observableList(productList);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productCol.setCellValueFactory(new PropertyValueFactory<>("product"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));

        productTbl.setItems(products);
    }
}
