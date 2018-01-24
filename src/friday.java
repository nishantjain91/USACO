/*
ID: nishant59
LANG: JAVA
TASK: friday
*/


import java.io.*;


public class friday {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("friday.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int numOfYears = Integer.parseInt(reader.readLine());

        int startingYear = 1900;

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysFor13 = new int[7];

        long startday = 13-31;
        //daysFor13[13%7]++;

        for(int year = startingYear;year< startingYear+numOfYears;year++){
            boolean leapYear = isLeapYear(year);
            for(int i=0;i<12;i++){
              if(i==0) {
                  startday = startday + days[11];
              }
              else if (i==2){
                  startday = startday + days[1]+(leapYear?1:0);
              }
              else{
                  startday = startday + days[i-1];
              }

                daysFor13[(int)(startday%7)]++;
            }
        }

        writer.printf("%d ",daysFor13[6]);

        for(int i=0;i<5;i++){
            writer.printf("%d ",daysFor13[i]);
        }
        writer.printf("%d",daysFor13[5]);
        writer.printf("\n");

        writer.close();
        reader.close();

    }

    public static boolean isLeapYear(int n){
        if(n%100==0)return n%400 ==0;
        else return n%4 ==0 ;
    }
}
