//This is the second program, easy from lecture 3
//probably not needed
import java.lang.Math;

public class presentValue{
    public static void main(String[] args){
        double[] c = {1, 2, 3};
        double rate = .05;                  //some percent
        double[] T = {1, 2, 3};             //time in years
        double t0 = 0;

        //Mt = M0 * e^(r(T-t0))
        double PV = c[0] * Math.exp(-rate *( T[0] - t0)) + 
                    c[1] * Math.exp(-rate *( T[1] - t0)) + 
                    c[2] * Math.exp(-rate *( T[2] - t0)) ;
        System.out.println(PV);
    }
}