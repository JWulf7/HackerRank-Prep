package interviewPrep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// https://www.hackerrank.com/challenges/min-max-riddle/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=hackerrank

public class MinMaxRiddle {
	// TODO optimize performance... passed 6/9 test cases... believe the others are just b/c of time limits???
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	
	


    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function
        // peek input
        // System.out.println("input####");
        // System.out.println("arr ->");
        // for (long l : arr) {
        //     System.out.println(l);
        // }
        // array  2 , 6 , 1 , 12                level 2 ->  :       2, 6        6, 1        1, 12
        int windowLevels = arr.length;
        long returnArray[] = new long[windowLevels];
        // iterate over every windowlevel
        for(int i = 1; i <= windowLevels; i++) {
            long levelMax = 0;
            // find the min value of each window for every windowlevel
                                                        // split arr into individual windows
                // iterate TO each window           
                for(int winStartIndex = 0; winStartIndex <= (windowLevels - i); winStartIndex++) {      
                    long windowMin = arr[winStartIndex];
                    
                    // iterate THROUGH each window...
                    for(int winPosition = 1; winPosition <= i; winPosition++) {   

                        // save each windows min
                        if(windowMin > arr[(winStartIndex +(winPosition-1))]) {
                            windowMin = arr[(winStartIndex +(winPosition-1))];
                        }
                        
                    }
                    // for each window.. if lowest value is highest for the level, set level max
                    if(windowMin > levelMax) {
                            levelMax = windowMin;
                        }
                }
                returnArray[i-1] = levelMax;
                
        }
                

        return returnArray; 
    }
    
    
    
    
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
	
	

}
