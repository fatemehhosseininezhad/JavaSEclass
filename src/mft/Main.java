package src.mft;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                ArrayList<Integer> numbers = new ArrayList<>();
                Scanner sc = new Scanner(System.in);
                int option;
                float sum = 0;

                do{
                    System.out.println("1)Add Number");
                    System.out.println("2)Count");
                    System.out.println("3)Sum");
                    System.out.println("4)Average");
                    System.out.println("5)Show List");
                    System.out.println("0)Exit");

                    System.out.print("Enter Option : ");
                    option = Integer.parseInt(sc.nextLine());

                    System.out.println("-----------------------------------------------");

                    switch (option) {
                        case 1:     //Add
                            System.out.print("Enter Number : ");
                            int x = Integer.parseInt(sc.nextLine());
                            numbers.add(x);
                            sum +=x;
                            System.out.println("Number Added To List");
                            break;

                        case 2:     //Count
                            System.out.println("Count : " + numbers.size());
                            break;

                        case 3:     //Sum
                            System.out.println("Sum : " + sum);
                            break;

                        case 4:     //Average
                            System.out.println("Average : " + (sum / numbers.size()));
                            break;

                        case 5:
                            System.out.println("List : " + numbers);
                            break;
                        case 0:
                            System.out.println("Exit");
                            break;
                        default:
                            System.out.println("Invalid Option !!!");
                    }

                    System.out.println("-----------------------------------------------");
                }while (option !=0);
            }
        }

