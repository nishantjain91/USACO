/*
ID: nishant59
LANG: JAVA
TASK: ariprog
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ariprog {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int max = Integer.parseInt(reader.readLine());

        int[] nums = new int[max * max + max * max + 1];

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= max; i++)
            for (int j = 0; j <= max; j++) {
                if (nums[i * i + j*j] == 0) {
                    nums[i * i + j*j] = 1;
                    numbers.add(i * i + j*j);
                }
            }

        Collections.sort(numbers);

        ArrayList<Pair> results = new ArrayList<>();
        int length = numbers.size();

        for (int i = 0; i < length - 2; i++) {
            int start = numbers.get(i);
            for (int k = i+1; k < length - 1; k++) {
                int diff = numbers.get(k) - start;
                int num = start;
                int j ;
                for (j = 1; j < n; j++) {
                    num = num + diff;
                    if (num >= nums.length || nums[num] == 0) break;
                }
                if (j == n){
                    results.add(new Pair(start,diff));
                }

            }
        }

        Collections.sort(results, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.diff != o2.diff){
                    int n = o1.diff< o2.diff?-1: 1;
                    return n;
                }
                int n = o1.start< o2.start?-1:1;
                return n;
            }
        });

        for(int i=0;i<results.size();i++){
            writer.printf("%d %d\n",results.get(i).start,results.get(i).diff);
        }
        if(results.size()==0)writer.println("NONE");
        writer.close();
        reader.close();
    }

    private static class Pair{
        int start;
        int diff;

        public Pair(int start,int diff){
            this.start=start;
            this.diff = diff;
        }
    }
}
