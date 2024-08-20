package src.tamrin02;

import src.tamrin02.da.ProductDa;
import src.tamrin02.entity.Product;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductDa productDa = new ProductDa();
        Product product = null;
        float sum=0;
        String name, price, count;
        int option = 0;
        do {
            try {
                System.out.println("1)Add Product");
                System.out.println("2)Edit Product");
                System.out.println("3)Delete Product");
                System.out.println("4)Invoice list");
                System.out.println("5)Total");
                System.out.println("6)Print invoice ");
                System.out.println("0) Exit");

                System.out.print("Enter Choice :");
                option = Integer.parseInt(scanner.nextLine());

                System.out.println("-----------------------------------------");

                switch (option) {
                    case 1:
                        product = new Product();
                        System.out.println("Enter name : ");
                        product.setName(scanner.nextLine());
                        System.out.println("Enter price : ");
                        product.setPrice(Float.parseFloat(scanner.nextLine()));
                        System.out.println("Enter count : ");
                        product.setCount(Integer.parseInt(scanner.nextLine()));
                        if (productDa.findByName(product.getName()) == null) {
                            productDa.save(product);
                            System.out.println("User Saved");
                        } else {
                            System.err.println(" name is duplicated, change It !!!");
                        }

                        break;
                    case 2:
                        product = new Product();
                        System.out.print("Enter Id : ");
                        product.setId(Integer.parseInt(scanner.nextLine()));

                        System.out.print("Enter name : ");
                        product.setName(scanner.nextLine());

                        System.out.print("Enter price : ");
                        product.setPrice(Float.parseFloat(scanner.nextLine()));

                        System.out.print("Enter count : ");
                        product.setCount(Integer.parseInt(scanner.nextLine()));

                        productDa.edit(product);
                        System.out.println("Product Edited");
                        break;

                    case 3:
                        System.out.print("Enter Id : ");
                        int id = Integer.parseInt(scanner.nextLine());

                        productDa.remove(id);
                        System.out.println("Product Removed");
                        break;

                    case 4:
                        System.out.println("Invoice List");
                        for (Product p: productDa.findAll()) {
                            System.out.printf("Name:%-20s Count:%-20s Price:%-20s Total:%-20s %n",p.getName(),p.getCount(),p.getPrice(),p.getTotal());

                        }

                        break;
                    case 5:

                      System.out.println("Sum price:");
                      for (Product p: productDa.findAll()) {
                          sum += p.getTotal();
                      }
                      System.out.println("Sum price:"+sum);
                      break;

                    case 6:
                        System.out.println("Print invoice");
                      for (Product p: productDa.findAll()) {
                          System.out.printf("Name:%-20s Count:%-20s Price:%-20s Total:%-20s %n",p.getName(),p.getCount(),p.getPrice(),p.getTotal());
                      }
                        for (Product p: productDa.findAll()) {
                            sum += p.getTotal();
                        }
                        break;
                    case 0:    
                        System.out.println("By");
                        break;
                    default:
                        System.err.println("Invalid Choice");
                        ;
                }
                System.out.println("-----------------------------------------");
            } catch (Exception e) {
                System.err.println("Error : " + e.getMessage() + "Try again Later !!!");
            }
        } while (option != 0);
    }
}


