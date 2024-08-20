package src.tamrin00;

public class T3 {
    public static void main(String[] args) {
        int a=28 , sum=0;
        for (int i=1;i<=a/2;i++){
            if (a%i==0) {
                sum = sum + i;

            }
        }
        if (sum==a){
            System.out.println("a is perfect");
        }
        else{
            System.out.println("a is not perfect");
        }
    }
}
