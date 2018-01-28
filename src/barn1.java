/*
ID: nishant59
LANG: JAVA
TASK: barn1
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class barn1 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringToken = new StringTokenizer(reader.readLine());

        int boards = Integer.parseInt(stringToken.nextToken())-1;
        int numOfStalls = Integer.parseInt(stringToken.nextToken());
        int cows = Integer.parseInt(stringToken.nextToken());

        int[] stalls = new int[numOfStalls+1];

        for(int i=0;i<=numOfStalls;i++){
            stalls[i]=-1;
        }

        for(int i=0;i<cows;i++){
            stalls[Integer.parseInt(reader.readLine())-1]=1;
        }

        int unscoversedStalls = 0;
        int consecutiveStalls = stalls[0];

        ArrayList<Integer> combinedStalls = new ArrayList<>();

        for(int i=1;i<numOfStalls;i++){
             if(stalls[i] * consecutiveStalls < 0){
                 combinedStalls.add(consecutiveStalls);
                 consecutiveStalls = stalls[i];
             }
             else{
                 consecutiveStalls+=stalls[i];
             }
        }
        combinedStalls.add(consecutiveStalls);

        if(combinedStalls.get(0)<0){
            unscoversedStalls+=combinedStalls.get(0);
            combinedStalls.remove(0);

        }

        if(combinedStalls.get(combinedStalls.size()-1)<0){
            unscoversedStalls+=combinedStalls.get(combinedStalls.size()-1);
            combinedStalls.remove(combinedStalls.size()-1);

        }

        Collections.sort(combinedStalls);

        for(int i=0;i<combinedStalls.size()&&boards>0;i++){
            if(combinedStalls.get(i)<0){
                unscoversedStalls+=combinedStalls.get(i);
                boards--;
            }
            if(combinedStalls.get(i)>=0){
                break;
            }
        }
        writer.println(numOfStalls-(-1*unscoversedStalls));

        writer.close();
        reader.close();

    }

}
