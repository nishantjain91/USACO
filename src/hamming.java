/*
ID: nishant59
LANG: JAVA
TASK: hamming
*/


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hamming {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());

        int max = (int)Math.pow(2,b+1)-1;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);

        for(int i=1;i<=max && result.size() < n;i++){
            if(safeDistance(result,i,d))
                result.add(i);
        }

        writer.print("0 ");
        for(int i=1;i<result.size();i++){
            writer.print(result.get(i));
            if((i+1)%10==0 || i == result.size()-1)writer.println();
            else writer.print(" ");
        }
        writer.close();
        reader.close();

    }

    private static boolean safeDistance(ArrayList<Integer> numbers, int number, int d){
        for(int i=0;i<numbers.size();i++){
            int a = numbers.get(i);
            int count =  count(a^number);
            if(count<d) return false;
        }
        return true;
    }

    private static int count(int i) {
        int count = 0;
        while(i >0){
            count++;
            i&=i-1;
        }
        return  count;
    }

}
