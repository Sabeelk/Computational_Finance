//program is used to calculate the discoutn factor and spot rate of par bonds
//**if yPar is same the rate is the same for all
import java.util.*;

public class parBonds{
    public static void main(String[] args){
        ArrayList<Double> d = new ArrayList<Double>();                                  //will hold all the Discount Factor values
        double[] t = {0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0};                          //t needed for spot rate
        double[] yPar = {.0426, .0455, .0476, .0503, .0528, .0557, .0583, .0609};       //dec, changes at each T (GIVEN AS NO PERCENTAGE USUALLY)

        //find the first d[0]
        d.add(1/(1 + (yPar[0]/2)));
        if(d.get(0) <= 0){
            System.out.println("Error d is less than 0");
            System.exit(1);
        }

        //loop to find the rest of the discount factors
        for(int i = 1; i < yPar.length; i++){
            //get the sum of all the previous discount factors
            double sum=0;
            for(int j=0; j < d.size(); j++) sum += d.get(j);

            //calculate the current d
            double temp = (1 - (yPar[i]/2) * sum)/ (1 + (yPar[i]/2));
            if(temp <= 0){
                System.out.println("Error d[" + i + "] is less than 0");
                System.exit(1);
            }
            //add d to the array
            d.add(temp);
        }

        //Print the spot rate spot rate is in percentage
        System.out.println("Discount Factor: " + d); 

        System.out.print("Spot Rate: "); 
        double[] rate = new double[d.size()]; 
        for(int i = 0; i < d.size(); i++ ){
            rate[i] = -(Math.log(d.get(i))) / (t[i]) * 100;
            System.out.print(rate[i] + " ");
        }
        System.out.println();
        //Print the answer array
    }
}