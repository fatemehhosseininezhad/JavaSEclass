package src.tamrin00;

public class T4 {
    public static void main(String[] args) {
        int a=17,b=5;
        if (a<b){
            for (int i=a;i<=b;i++){
                System.out.printf("%s  ",i);
            }
        }
        else{
            for (int i=a;i>=b;i--){
                System.out.printf("%s  ",i);
            }
        }
    }
}
