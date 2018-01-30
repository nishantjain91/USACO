/*
ID: nishant59
LANG: JAVA
TASK: skidesign
*/


import java.io.*;
import java.util.Arrays;

public class skidesign {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int numOfHills = Integer.parseInt(reader.readLine());

        int[] hills = new int[numOfHills];

        for(int i=0;i<numOfHills;i++){
            hills[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(hills);
        int min = hills[0];
        int max = hills[numOfHills-1];


        int minCost = Integer.MAX_VALUE;

        for(int i=min;i<= max-17;i++){
            int small = i;
            int big = i+17;
            int cost =0;
            for(int j=0;j<numOfHills;j++){
                if(hills[j]<small){
                    cost+= (small-hills[j])*(small-hills[j]);
                }
                if(hills[j]>big){
                    cost+= (hills[j]-big) *(hills[j]-big);
                }
            }
            if(cost<minCost)minCost=cost;
        }

        writer.println(minCost);


        writer.close();
        reader.close();

    }

}
