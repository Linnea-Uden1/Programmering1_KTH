// package A1;
import java.text.DecimalFormat;
//Temperatures1.java
// proccessing measurement data
/**********************************************************************
A problem: processing measurement data
Temperature measurements are taken in one and the same place for a
couple
of weeks. The measurements are taken regularly the same number of
measurements each week. At the end of the measurement period the
collected
data is to be processed: for each week the least, the greatest and the
average temperature is to be determined. The least, greatest and
average temperature for the whole period is also to be computed.
A solution to the problem
This program reads the temperatures and displays them. Then the least,
greatest and average temperature for each week is computed and stored.
These results are printed on the standard output device. Finally, the
least, greatest and average temperature over the whole measurement
period is decided. These results are also printed on the standard
output device.

**********************************************************************/
// import java.util.*; // Scanner, Locale
// import static java.lang.System.out;
import java.util.Locale;
import java.util.Scanner;
public class Temperatures1 {



     public static void main (String[] args)
    {

        System.out.println("TEMPERATURES\n");
        // input tool
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        // enter the number of weeks and measurements
        System.out.print("number of weeks: ");
        int nofWeeks = in.nextInt();
        System.out.print("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();
        // storage space for temperature data
        double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];


        // read in the temperatures
        for (int week = 1; week <= nofWeeks; week++)
        {

            System.out.println("temperatures - week " + week + ":");
            for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
                t[week][measurement] = in.nextDouble();
        }
        System.out.println("");


        // show the temperatures
        System.out.println("the temperatures");
        for (int week = 1; week <= nofWeeks; week++)
        {
            System.out.print("Week: " +  week + "| ");
            for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
            System.out.print(t[week][measurement] + " ");
            System.out.println("");
        }
        System.out.println("");


        // the least, greatest and average temperatures - weekly
        double[] minT = new double[nofWeeks + 1];
        double[] maxT = new double[nofWeeks + 1];
        double[] sumT = new double[nofWeeks + 1];
        double[] avgT = new double[nofWeeks + 1];
        // add code here

        //Find minT, maxT, sumT and avgT
        for(int week = 1; week <= nofWeeks; week++)
        {
            minT[week] = t[week][1];
            maxT[week] = t[week][1];
            sumT[week] = t[week][1];
            for(int measurement = 2; measurement <= nofMeasurementsPerWeek; measurement++)
            {
                if (minT[week] > t[week][measurement]) {
                    minT[week] = t[week][measurement];
                }
                if (maxT[week] < t[week][measurement]) {
                    maxT[week] = t[week][measurement];
                }

                sumT[week] += t[week][measurement];
            }
            // Calculate avgT 
            avgT[week] = sumT[week]/nofMeasurementsPerWeek;
        }
        //Create class to use to round of the avrage values 
        DecimalFormat df = new DecimalFormat("####0.00");

        // show the least, greatest and average temperatures
        System.out.println("the least, greatest and average temperatures" + " - weekly");
        System.out.print("Least:    ");
        for (int week = 1; week <= nofWeeks; week++)
            System.out.print(minT[week] + " ");
            System.out.println("");
        
        System.out.print("Greatest: ");
        for (int week = 1; week <= nofWeeks; week++)
            System.out.print(maxT[week] + " ");
            System.out.println("");
        
        System.out.print("Average:  ");
        for (int week = 1; week <= nofWeeks; week++)
            System.out.print(df.format(avgT[week]) + " ");
            System.out.println("");
            System.out.println();


        // the least, greatest and average temperatures - whole period
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double avgTemp = 0;

        // add code here


        //Find max and min value of all weeks
        for(int week = 2; week <= nofWeeks; week++){
           // minTemp = minT[1];
            //maxTemp = maxT[1];
            if (minTemp > minT[week]) {
                minTemp = minT[week];
            }
            if (maxTemp < maxT[week]) {
                maxTemp = maxT[week];
            }

            sumTemp += sumT[week];
        }

        //Calculate the avragetemp for all the values
        avgTemp = sumTemp / (nofWeeks * nofMeasurementsPerWeek);

        // show the least, greatest and average temperature for
        // the whole period
        System.out.println("the least, greatest and average temperature" + " - whole period");
        System.out.println("Least:    " + minTemp + "\n" + "Greatest: " + maxTemp + "\n" + "Average:  " + df.format(avgTemp));

        in.close();

    }
}