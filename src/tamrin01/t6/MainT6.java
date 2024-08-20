package src.tamrin01.t6;

import java.util.ArrayList;
import java.util.Scanner;

public class MainT6 {

        public static void main(String[] args) {
            ArrayList<StudentT6> persons = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            int option;
            float sum=0;

            do {
                System.out.println("1)Add new student");
                System.out.println("2)Print  average age of students");
                System.out.println("3)Count number of students");
                System.out.println("4)Print List of all students");
                System.out.println("0)Exit");

                System.out.print("Enter Option : ");
                option = Integer.parseInt(sc.nextLine());

                System.out.println("-----------------------------------------------");

                switch (option) {
                    case 1:     //Add
                        StudentT6 std = new StudentT6();
                        System.out.print("Enter name of student : ");
                        std.name=sc.nextLine();
                        System.out.print("Enter age of student : ");
                        std.age=Integer.parseInt(sc.nextLine());
                        persons.add(std);
                        sum += std.age;
                        break;
                    case 2:     //Average
                        System.out.println("Average : " + (sum / persons.size()));
                        break;
                    case 3:     //Count
                        System.out.println("Count : " + persons.size());
                        break;

                    case 4:      //List
                        System.out.println(" List of students ( name , age ):");
                        for (StudentT6 person : persons) {
                            System.out.println(person.name+','+person.age);

                        }
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
