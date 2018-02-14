/*
ID: nishant59
LANG: JAVA
TASK: runround
*/


import java.io.*;

public class runround {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("runround.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(reader.readLine());

        while(!isRound(++m)){

        }
        writer.println(m);

        writer.close();
        reader.close();

    }

    private static boolean isRound(int n){
        int[] number = new int[10];

        String s = String.valueOf(n);

        int ind =0;
        int oldind=0;
        for(int i=0;i<s.length();i++){
            oldind=ind;
            ind = (ind+(s.charAt(ind)-'0'))%s.length();
            if(ind == oldind || s.charAt(ind)=='0') return false;
            number[s.charAt(ind)-'0']++;
        }
        for(int i=0;i<10;i++)
            if(number[i]>1) return false;
        return true;

    }
}
