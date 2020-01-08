import java.lang.Math;

public class macaulayDuration{
    public static void main(String[] args){
        double[] t = {0, 0.1, 0.5, 0.7};
        double[] c = {6, 6, 6, 6};              //coupon will stay static
        double[] T = {.5, 1.0, 1.5, 2.0};
        double y = .03;                         //the yield, given as percent
        double f = 2;                           //frequency, paid out twice a year

        double fv1 = ( T[0] - t[0])*(c[0]/f)/Math.pow((1+(y/f)), (f *( T[0] - t[0]))) + 
        (T[1] - t[0])*(c[1]/f)/Math.pow((1+(y/f)), (f *( T[1] - t[0]))) + 
        (T[2] - t[0])*(c[2]/f)/Math.pow((1+(y/f)), (f *( T[2] - t[0]))) + 
        (T[3] - t[0])*(100 + c[3]/f)/Math.pow((1+(y/f)), (f *( T[3] - t[0])));

        System.out.println(fv1);
    }
}