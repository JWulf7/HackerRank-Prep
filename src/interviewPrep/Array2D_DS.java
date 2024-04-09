package interviewPrep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
     
     
     /*
     [
         [1, 1, 1, 0, 0, 0], 
         [0, 1, 0, 0, 0, 0], 
         [1, 1, 1, 0, 0, 0], 
         [0, 0, 2, 4, 4, 0], 
         [0, 0, 0, 2, 0, 0], 
         [0, 0, 1, 2, 4, 0]]
     */
     
      /*
     [
         [-1 -1 0 -9 -2 -2],        -6  
         [-2 -1 -6 -8 -2 -5], 
         [-1 -1 -1 -2 -3 -4], 
         [-1 -9 -2 -4 -4 -5], 
         [-7 -3 -3 -2 -9 -9], 
         [-1 -3 -1 -2 -4 -5]
         ]
     */
     

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        // check input
        System.out.println(arr);
        int maxHourglassSum = 0;
        int level = 0;

        
        // create an hourglasssum for each level, l 1-4
        while(level < 4) {
            
            // w/in each step... calculate the hourglass sum for each column, c 1 - 4
            for(int c = 0; c <=3; c++) {
                int smallSum = 0;
                smallSum = ((arr.get(level).get(c)) + (arr.get(level).get(c+1)) + (arr.get(level).get(c+2)));
                smallSum += (arr.get(level+1).get(c+1));
                smallSum += ((arr.get(level+2).get(c)) + (arr.get(level+2).get(c+1)) + (arr.get(level+2).get(c+2)));
                if((level == 0) && (c == 0)) {
                    maxHourglassSum = smallSum;
                    } else if(smallSum > maxHourglassSum) maxHourglassSum = smallSum;
                
            }
            
            
            
            // increment level
            level ++;
        }
        
        
            
                // if sum > maxhourglass sum... save as new hourglasssum..
        
        
        return maxHourglassSum;   // returns max hourglass sum
    }
    


}



public class Array2D_DS {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
	
	
	
	
	

}




