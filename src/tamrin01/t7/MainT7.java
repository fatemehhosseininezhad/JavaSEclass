package src.tamrin01.t7;

import java.util.ArrayList;
import java.util.Scanner;

public class MainT7 {
    public static void main(String[] args) {
        ArrayList<ProductT7> info = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int option;
        float sum = 0;

        do {
            System.out.println("1)Add new product");
            System.out.println("2)The total price of the products:");
            System.out.println("3)Print List of all products");
            System.out.println("0)Exit");

            System.out.print("Enter Option : ");
            option = Integer.parseInt(sc.nextLine());

            System.out.println("-----------------------------------------------");


            switch (option) {
                case 1:
                    ProductT7 pru = new ProductT7();
                    System.out.println("Enter product name:");
                    pru.name = sc.nextLine();
                    System.out.println("Enter product price:");
                    pru.price = Integer.parseInt(sc.nextLine());
                    info.add(pru);
                    sum += pru.price;
                    break;
                case 2:
                    System.out.println(sum);
                    break;
                case 3:
                    System.out.println("List of all products:(product,price) ");
                    for (ProductT7 product : info) {
                        System.out.println(product.name + ',' + product.price);
                    }
                    break;
                case 0:
                    System.out.println("exite");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
            System.out.println("-----------------------------------------------");
        }
        while (option != 0);
    }
}
