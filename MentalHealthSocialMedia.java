import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MentalHealthSocialMedia {

    public static void main (String args []) throws FileNotFoundException {
        exerciseVersusStress();
    
    }

    public static void exerciseVersusStress() throws FileNotFoundException {
        //​​1. Grab the first line of the file (the header) and split into and array of strings using .split()
        File f = new File("/Users/svaldes/Desktop/sasha-dataset-project/Mental_Health_and_Social_Media_Balance_Dataset.csv");
        Scanner s = new Scanner(f);
        String [] header = s.nextLine().split(",");

        // a. Find the index of "Exercise_Frequency(week)" in header → exerciseIndex
        int exerciseIndex = 0;
        //b. Find the index of "Stress_Level(1-10)" in header → stressIndex
        int stressIndex = 0;
        
        for (int i = 0; i < header.length; i++){
            if (header[i].equals("Stress_Level(1-10)")){
                stressIndex = i;
            } else if (header[i].equals("Exercise_Frequency(week)")){
                exerciseIndex = i;
            }
        }

        //2. Initialize an array of ArrayList integers with the length of 8 (index 0 = exercised 0 times per week, 1 - exercised once per week, etc) → stressList
        ArrayList<Double> [] stressList = new ArrayList[8];
        for (int i = 0; i < stressList.length; i++) {
            stressList[i] = new ArrayList<Double>();
        }

        //3. Go through each line of the file (while there’s a line remaining):
        while (s.hasNextLine()){
            //a. Split up the line into an array of strings using → line 
            String [] line = s.nextLine().split(",");
            //b. Use line[exerciseIndex] to find the frequency of exercise → exFreq
            int exFreq = (int)Double.parseDouble(line[exerciseIndex]);
            //c. Access the value of stress levels using line[stressIndex] --> stressLevel
            double stressLevel = Double.parseDouble(line[stressIndex]);
            //d. Add each of the stress level values to the arraylist at the index (freq) in stressList using .add()
            stressList[exFreq].add(stressLevel);

        }

        //4. Use a for loop to find the average of the contents of each arraylist in stressList
        //a. Initialize a double array → correlation
        double [] correlation = new double [8];
        for (int i = 0; i < stressList.length; i++){
            double temp = 0.0;
            //b. Use a nested for loop to set each value of correlation to the sum of all values of stressList[i] 
            for (int j = 0; j < stressList[i].size(); j++){
                temp = temp + stressList[i].get(j);
            }
            //divide by the number of values in the arrayList to get the average
            double avg = temp / (double)(stressList[i].size());
            correlation[i] = avg;
        }

        //5. Iterate through correlation and print it out using a visual (eg 2.899 is displayed as 3 stars) and print a concluding sentence
        System.out.println();
        System.out.println("Stress Levels v Weekly Exersise Frequency");
        for (int i = 0; i < correlation.length; i++){
            System.out.print( String.valueOf(i) + ": ");
            for (int j = 0; j < Math.round(correlation[i]); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("The more stars next to the frequency, the higher the stress levels.");
        System.out.println("Contrary to popular belief, people who rarely exercise and those who exercise nearly every day experience less stress than those who exercise a few times a week.");
        System.out.println("");

    }
}
