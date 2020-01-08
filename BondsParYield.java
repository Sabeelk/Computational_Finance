//This is the 5th program written
//IMPORTANT PROGRAM - used to calculate par yields
//Can be modified to find value of non new issued bonds
import java.lang.Math;

public class BondsParYield{
    public static void main(String[] args){
        double[] t = {0.2};                    //this is t0
        double[] c = {6, 6, 4, 6};             //coupon changes, but possibly not
        double[] T = {0.4, 0.9, 1.4, 1.9};     //bond gets issued at t-issue, +0.5 until maturity
        double f = 2;

        //test all percentages from 0% to 10%
        for(double y = .0000; y < .10000; y += .00001){
            double fv = (c[0]/f)/Math.pow((1+(y/f)), (f *( T[0] - t[0]))) + (c[1]/f)/Math.pow((1+(y/f)), (f *( T[1] - t[0])))
            + (c[2]/f)/Math.pow((1+(y/f)), (f *( T[2] - t[0]))) + (100 + c[3]/f)/Math.pow((1+(y/f)), (f *( T[3] - t[0])));

            if(fv > 99.998 && fv < 100.002) System.out.println(y * 100 + "% | "  + fv);         //change if MKT price is diff
        }

        // double fv3 = (c[0]/f)/Math.pow((1+(y/f)), (f *( T[0] - t[2]))) + (c[1]/f)/Math.pow((1+(y/f)), (f *( T[1] - t[2])))
        //  + (c[2]/f)/Math.pow((1+(y/f)), (f *( T[2] - t[2]))) + (100 + c[3]/f)/Math.pow((1+(y/f)), (f *( T[3] - t[2])));

        // double fv4 = (c[0]/f)/Math.pow((1+(y/f)), (f *( T[0] - t[3]))) + (c[1]/f)/Math.pow((1+(y/f)), (f *( T[1] - t[3])))
        // + (c[2]/f)/Math.pow((1+(y/f)), (f *( T[2] - t[3]))) + (100 + c[3]/f)/Math.pow((1+(y/f)), (f *( T[3] - t[3])));

        // System.out.println(fv2 + " | "  + y);
        // System.out.println(fv3);
        // System.out.println(fv4);
    }
}