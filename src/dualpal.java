/*
ID: nishant59
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.StringTokenizer;

public class dualpal {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer s = new StringTokenizer(reader.readLine());
        int num = Integer.parseInt(s.nextToken());
        int start = Integer.parseInt(s.nextToken()) + 1;

        int numFound = 0;
        while (numFound != num) {
            if (isPalindrome(start)) {
                writer.println(start);
                numFound++;
            }
            start++;
        }

        writer.close();
        reader.close();
    }

    private static boolean isPalindrome(int number) {
        int numPalindrome = 0;
        for (int base = 2; base <= 10; base++) {
            String s = Integer.toUnsignedString(number, base);
            if(stringPalindrome(s)){
                numPalindrome++;
                if(numPalindrome==2)return true;
            }
        }
        return false;
    }

    private static  boolean stringPalindrome(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return  false;
        }
        return true;
    }
}
