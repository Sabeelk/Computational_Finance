import java.lang.Math;

public class firstEquation{
    public static void main(String[] args){
        double m0 = 5.25;
        double rate = .05;      //some percent
        double T = 2;           //time in years
        double t0 = 0;

        //Mt = M0 * e^(r(T-t0))
        double mT = m0 * Math.exp(rate *( T - t0));

        System.out.println(mT);

    }
}