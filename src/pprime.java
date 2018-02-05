/*
ID: nishant59
LANG: JAVA
TASK: pprime
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class pprime {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer> resultArray = new ArrayList<>();
        generatePalindrome(a,b,0,"",resultArray,String.valueOf(b).length(),true);

        Collections.sort(resultArray);
        for(int i=0;i<resultArray.size();i++)
            writer.println(resultArray.get(i));

        writer.close();
        reader.close();
    }

    private static void generatePalindrome(int a, int b, int depth, String result, ArrayList<Integer> resultArray, int length, boolean start){
        int res = result.length()!=0 && result.length() < 10 ?Integer.parseInt(result):0;
        if(res%10!= 0  && res >= a && res <= b){
            if(isPrime(res)) resultArray.add(res);
        }
        if(String.valueOf(result).length() > length) return;

        for(int i=0;i<=9;i++){
             String s  =  String.valueOf(i) + String.valueOf(result) +  String.valueOf(i) ;
             generatePalindrome(a,b,depth,s,resultArray,length,false);
        }
        if(start){
            for(int i=0;i<=9;i++){
                String s  =  String.valueOf(i) ;
                generatePalindrome(a,b,depth,s,resultArray,length,false);
            }

        }

    }

    private static boolean isPrime(int n)
    {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}

