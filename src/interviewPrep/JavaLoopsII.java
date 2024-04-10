package interviewPrep;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true
public class JavaLoopsII {

	public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            myMethod(a, b, n);
        }
        in.close();
        
        
    }
            // 0    2   10
            // 5    3   5
    
    public static void myMethod(int a, int b, int n) {
        String resultString = "";
        ArrayList<Integer> sequences = new ArrayList<>();
        double baseFormula = (a + (Math.pow(2,0)*b));   
        // System.out.println("baseFormula -> (" + a + " + (Math.pow(2,0)*" + b + "))");
        resultString = Integer.toString((int)baseFormula);

        double next = baseFormula;
        // for loop to do forumula n times...
        for(int i = 1; i < n; i++) {
            int times = n;
            next += (Math.pow(2, i)*b);

            sequences.add((int)next);
        }

        
        for(int s: sequences) resultString=resultString.concat(" "+s);
        System.out.println(resultString);
    }

}
