/*
ID: nishant59
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class frac1 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<fraction> result = new ArrayList<>();
        for(int i =1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(gcd(i,j)==1){
                    result.add(new fraction(i,j));
                }
            }
        }

        Collections.sort(result, new Comparator<fraction>() {
            @Override
            public int compare(fraction o1, fraction o2) {
               if( o1.n *o2.d > o2.n * o1.d)
                   return 1;
               return -1;
            }
        });

        writer.println("0/1") ;
        for(int i=0;i<result.size();i++){
            writer.println(result.get(i).n + "/" + result.get(i).d);
        }
        writer.println("1/1") ;

        writer.close();
        reader.close();
    }

    private static int gcd(int i, int j) {
        if(i==0) return 1;
        if(j%i==0) return i;
        return gcd(j%i,i);

    }


    private static class fraction{
        int n;
        int d;
        public fraction(int n,int d){
            this.n = n;
            this.d = d;
        }
    }
}
