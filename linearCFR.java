//program is used to calculate the discoutn factor and spot rate of par bonds
//It;s possible rates may come from the parBonds program
import java.util.*;

public class linearCFR{
    public static void main(String[] args){
        //elements that need to be modified
        double[] t = {.1513, 1.1513, 1.8487, 2.8487, 4.1513};                            //holds the t values
        double[] r = {4.22, 4.50, 4.71, 4.98, 5.24, 5.54, 5.81, 6.09};                //holds the rates **imp, SAME SIZE AS YIELDCURVE

        double[] yieldCurve = {0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0};
        double[] rLin = new double[t.length];           //will have rLin, cha
        double[] rCFR = new double[t.length];           //will have rCFR

        Arrays.sort(t);                     //sort the array just in case;

        for(int i=0; i<t.length; i++){
            int checker = Arrays.binarySearch(yieldCurve, t[i]);
            //if the r is above or below yield curve, return the rate of 1st or last t
            if(t[i] <= yieldCurve[0]){ 
                rLin[i] = r[0]; 
                rCFR[i] = r[0]; 
            }
            else if(t[i] >= yieldCurve[yieldCurve.length-1]){ 
                rLin[i] = r[r.length-1]; 
                rCFR[i] = r[r.length-1];
            }
            //case where the t, is equal to a point on the yieldCurve
            else if(checker > 0){
                rLin[i] = r[checker]; 
                rCFR[i] = r[checker];
            }
            //case where t, is between two points
            else if(checker < 0){
                double ri = r[checker * -1 - 2];
                double rip1 = r[checker * -1 - 1];
                double ti = yieldCurve[checker * -1 - 2];
                double tip1 = yieldCurve[checker * -1 - 1];

                double lambda = (t[i] - ti)/ (tip1 - ti);            //calculate lambda
                
                //the juice
                rLin[i] = (1 - lambda) * ri + lambda * rip1;                
                rCFR[i] = ((1 - lambda) * ri * ti + lambda * rip1 * tip1) / t[i]; 
            }
        }

        System.out.println("rLin : " + Arrays.toString(rLin));
        System.out.println("rCFR : " + Arrays.toString(rCFR));
    }
}