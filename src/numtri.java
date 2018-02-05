/*
ID: nishant59
LANG: JAVA
TASK: numtri
*/


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class numtri {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        ArrayList<ArrayList<Integer>> pyramid = new ArrayList<>(n);

        for(int i=1;i<=n;i++){
            pyramid.add(new ArrayList<>());
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for(int j=0;j<i;j++){
                pyramid.get(i-1).add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }

        for(int i=n-2;i>=0;i--){
            int size = i+1;
            for(int j=0;j<size;j++){
                pyramid.get(i).set(j,Math.max(pyramid.get(i+1).get(j),pyramid.get(i+1).get(j+1))+pyramid.get(i).get(j));
            }
        }
        writer.println(pyramid.get(0).get(0));
        writer.close();
        reader.close();
    }
}
