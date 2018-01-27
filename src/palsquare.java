/*
ID: nishant59
LANG: JAVA
TASK: palsquare
*/

import java.io.*;

public class palsquare {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int base = Integer.parseInt(reader.readLine());

        for (int i = 1; i < 300; i++) {
            int sqaure = i * i;
            if (isPalindrome(sqaure, base)) {
                writer.printf("%s %s\n", Integer.toUnsignedString(i, base).toUpperCase(), Integer.toUnsignedString(sqaure, base).toUpperCase());
            }
        }
        writer.close();
        reader.close();
    }

    private static boolean isPalindrome(int number, int base) {
        String s = Integer.toUnsignedString(number, base);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}
