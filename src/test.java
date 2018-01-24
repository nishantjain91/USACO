/*
ID: nishant59
LANG: JAVA
TASK: test
*/


import java.io.*;
import java.util.StringTokenizer;

public class test {
    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("test.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        writer.println(a+b);
        writer.close();
        reader.close();

    }
}
