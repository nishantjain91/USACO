/*
ID: nishant59
LANG: JAVA
TASK: milk2
*/


import java.io.*;
import java.util.StringTokenizer;


public class milk2 {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] time = new int[1000000];

        int timestart=Integer.MAX_VALUE;
        int timeend=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            StringTokenizer stringToken = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(stringToken.nextToken());
            int end = Integer.parseInt(stringToken.nextToken());
            time[start]++;
            time[end]--;
            if(start<timestart)timestart=start;
            if(end>timeend)timeend=end;
        }

        int maxIdle = 0;
        int maxNonIdle = 0;

        int idle=0;
        int nonIdle=0;

        for(int i=timestart;i<=timeend;i++){
            if(i!=0)
                time[i] = time[i]+time[i-1];
        }
        for(int i=timestart;i<=timeend;i++){
            if(time[i]==0){
               idle++;
               if(nonIdle>maxNonIdle)maxNonIdle = nonIdle;
               nonIdle=0;
            }
            else{
                nonIdle++;
                if(idle>maxIdle)maxIdle = idle;
                idle=0;
            }
        }

        writer.printf("%s %s\n",maxNonIdle,maxIdle);
        writer.close();
        reader.close();

    }

}
