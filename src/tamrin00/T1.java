package src.tamrin00;

public class T1 {
    public static void main(String[] args) {
            int a=0 , b=1 ,c ;
            for (int i=3 ; i<=40 ;i++){
                c=a+b;
                a=b;
                b=c;
                if(i>=20){
                    System.out.printf("%s  ",c);}
            }
        }
}
