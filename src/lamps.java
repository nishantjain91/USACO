/*
ID: nishant59
LANG: JAVA
TASK: lamps
*/


import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class lamps {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        TreeSet<String> result = new TreeSet<>();
        int numOfLamps = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int[] lamps = new int[numOfLamps];
        for(int i=0;i<numOfLamps;i++)
            lamps[i] = -1;
        int a;
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        while((a=Integer.parseInt(stringTokenizer.nextToken()))!=-1){
            lamps[a-1]=1;
        }
        int res=0;
        stringTokenizer = new StringTokenizer(reader.readLine());
        while((a=Integer.parseInt(stringTokenizer.nextToken()))!=-1){
            lamps[a-1]=0;
        }

        for(int k=0;k<16;k++){
            int state = 0;
            int[] lampsstate = new int[numOfLamps];

            for(int i=0;i<numOfLamps;i++)
                lampsstate[i] = 1;
            if((k&1)!= 0){
                state++;
                for(int i=0;i<numOfLamps;i++)
                    lampsstate[i] = lampsstate[i]==1?0:1;
            }
            if((k&2)!= 0){
                state++;
                for(int i=0;i<numOfLamps;i++)
                    if(i%2==0)
                        lampsstate[i] = lampsstate[i]==1?0:1;
            }
            if((k&4)!= 0){
                state++;
                for(int i=0;i<numOfLamps;i++)
                    if(i%2==1)
                        lampsstate[i] = lampsstate[i]==1?0:1;
            }
            if((k&8)!= 0){
                state++;
                for(int i=0;i<numOfLamps;i++)
                    if(i%3==0)
                        lampsstate[i] = lampsstate[i]==1?0:1;
            }
            boolean print = true;
            for(int i=0;i<numOfLamps;i++){
                if(lamps[i]!=-1 && lamps[i]!= lampsstate[i]){
                    print = false;
                    break;
                }
            }
            int diff =c-state;

            if(print && diff >=0 && diff%2==0){
                res++;
                StringBuffer s = new StringBuffer();
                for(int i=0;i<numOfLamps;i++){
                    s.append(lampsstate[i]);
                }
                result.add(s.toString());
            }
        }
        if(res==0) writer.println("IMPOSSIBLE");
        else{
            for(String s: result)
                writer.println(s);
        }

        writer.close();
        reader.close();

    }

}
