/*
ID: nishant59
LANG: JAVA
TASK: ride
*/


import java.io.*;

public class ride {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("ride.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));


        String ufo = reader.readLine();
        String group = reader.readLine();

        int num1 = 1,num2=1;

        for(int i=0;i<ufo.length();i++){
            num1 = (num1* (ufo.charAt(i)-'A'+1))%47;
        }

        for(int i=0;i<group.length();i++){
            num2 = (num2* (group.charAt(i)-'A'+1))%47;
        }

        if(num1==num2)writer.println("GO");
        else writer.println("STAY");

        writer.close();
        reader.close();

    }
}
