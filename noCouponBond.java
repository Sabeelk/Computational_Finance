//3rd program written. Likely will not be needed
//This program is for Bonds without any coupon
import java.lang.Math;

public class noCouponBond{
    public static void main(String[] args){
        double F = 100;                    //most likely will always be 100
        double y = .04;                    //this is the yield
        double n = 5;                      //number of iterations

        double fv = F / Math.pow((1 + y/2), n);
        System.out.println(fv);
    }
}