package src.tamrin00;

public class T2 {
    public static void main (String[] args){
        Integer a=0,b=1,c=0;
        for (int i=3;i<=50;i++){
            c=a+b;
            System.out.println(c/b.doubleValue());
            a=b;
            b=c;

        }
    }

}
