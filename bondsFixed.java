//Third program written
//This program is for fixed length bonds, the exponent is known
//These are new issued bonds
import java.lang.Math;

public class bondsFixed{
    public static void main(String[] args){
        double F = 100;                    //most likely will always be 100
        double y = .08;                    //this is the yield
        double n = 2;                      //number of iterations
        double c = 8;                      //coupon in percent value yield


        double fv = 0;
        for(int i=1; i <= n; i++){
            if(i==n)
                fv +=(F + (c/2))/Math.pow((1 + (y/2)), i);
            else 
                fv +=(c/2)/Math.pow((1 + (y/2)), i);
        }
        System.out.println(fv);
    }
}