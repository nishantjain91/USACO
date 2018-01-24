/*
ID: nishant59
LANG: JAVA
TASK: beads
*/


import java.io.*;


public class beads {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("beads.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String beads = reader.readLine();

        int beadCollected =0;

        int red =0, blue=0;
        for(int i=0;i<n;i++){
            if(beads.charAt(i)=='r')
                red++;
            else if(beads.charAt(i)=='b')
                blue++;
        }

        if(red> (n-2) || blue>(n-2)) beadCollected=n;
        else if(red==0 && blue==0) beadCollected=n;
        else{
            beads = beads+beads+beads;

            for(int i=n;i<n+n;i++){
                int start =i;
                int end = i-1;
                int right=0;
                int left =0;
                while(beads.charAt(start)=='w'){
                    start++;
                    right++;
                }
                char color  = beads.charAt(start);
                while (beads.charAt(start)=='w' || beads.charAt(start)==color){
                    start++;
                    right++;
                }

                while(beads.charAt(end)=='w'){
                    end--;
                    left++;
                }
                char color1  = beads.charAt(end);
                while (beads.charAt(end)=='w' || beads.charAt(end)==color1){
                    end--;
                    left++;
                }

                if(beadCollected<left+right && left+right <= n)
                    beadCollected = left+right;
            }
        }

        writer.println(beadCollected);
        writer.close();
        reader.close();

    }

}
