import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MentalHealthSocialMedia {

    public static void main (String args []) throws FileNotFoundException {

    
    }

    public static void doesPluribusWin() throws FileNotFoundException {
        //​​1. Grab the first line of the file (the header) and split into and array of strings using .split()
        File f = new File("/Users/svaldes/Desktop/sasha-dataset-project/Mental_Health_and_Social_Media_Balance_Dataset.csv");
        Scanner s = new Scanner(f);
        String [] header = s.nextLine().split(",");

        //Find the index of "Exercise_Frequency(week)" in header → exerciseIndex
        int exerciseIndex = 0;
        // Find the index of "Stress_Level(1-10)" in header → stressIndex
        int stressIndex = 0;
        
        for (int i = 0; i < header.length; i++){
            if (header[i].equals("Stress_Level(1-10)")){
                exerciseIndex = i;
            } else if (header[i].equals("Exercise_Frequency(week)")){
                stressIndex = i;
            }
        }

        //2. Initialize an array of ArrayList strings with the length of 8 (index 0 = exercised 0 times per week, 1 - exercised once per week, etc) → stressList
        ArrayList <String>[] stressList = new ArrayList <String> [8];

        //3. Go through each line of the file (while there’s a line remaining):
        while (s.hasNextLine()){
            //Split up the line into an array of strings using → line 
            String [] line = s.nextLine().split(",");
            int ex = Integer.parseInt(line[exerciseIndex]);
     
            
            stressList[ex].add(line[stressIndex]);
        }

   
    //     Use line[exerciseIndex] to find the frequency of exercise → freq
    //     Access the value of stress levels using line[stressIndex]
    //     Add each of the stress level values to the arraylist at the index (freq) in stressList using .add()
    //     4. Use a for loop to find the average of the contents of each arraylist in stressList
    //     Initialize a double array → correlation
    //     Use a nested for loop to set each value of correlation to the sum of all values of stressList[i] 
    //     divide by the number of values in the arrayList to get the average
    //     5. Iterate through correlation and print it out using a visual (eg 2.899 is displayed as 3 stars) and print a concluding sentence

    }
}
