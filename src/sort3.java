/*
ID: nishant59
LANG: JAVA
TASK: sort3
*/


import java.io.*;

public class sort3 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n];

        int one=0,two=0,three =0;

        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(reader.readLine());
            if(nums[i]==1)one++;
            if(nums[i]==2)two++;
            if(nums[i]==3)three++;
        }

        int onetwo = 0;
        int onethree = 0;
        int twoone=0,twothree=0;
        int threeone=0, threetwo=0;
        int i=0;
        for(;i<one;i++){
            if(nums[i]==2)onetwo++;
            if(nums[i]==3)onethree++;
        }
        for(;i<one+two;i++){
            if(nums[i]==1)twoone++;
            if(nums[i]==3)twothree++;
        }
        for(;i<one+two +three;i++){
            if(nums[i]==1)threeone++;
            if(nums[i]==2)threetwo++;
        }
        
        int changes =0;
        int swaps = Math.min(onetwo ,twoone);
        changes+=swaps;
        swaps = Math.min(onethree,threeone);
        changes+=swaps;
        int dob = onetwo+onethree - changes;
        swaps =Math.min(twothree,threetwo);
        changes+=swaps;
        changes += 2*dob;

        writer.println(changes);
        writer.close();
        reader.close();

    }

}
