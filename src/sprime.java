/*
ID: nishant59
LANG: JAVA
TASK: sprime
*/


import java.io.*;
import java.util.ArrayList;

public class sprime {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<Integer> resultArray = new ArrayList<>();
        generatePrime(n,resultArray,0,true,0);

        for(int i=0;i<resultArray.size();i++)
            writer.println(resultArray.get(i));

        writer.close();
        reader.close();
    }

    private static void generatePrime(int n,  ArrayList<Integer> resultArray, int numlen, boolean start, int number){

        if(numlen==n){
            resultArray.add(number);
            return;
        }


        if(start){
            for(int i=1;i<=9;i++){
                if(isPrime(i)){
                    generatePrime(n,resultArray,numlen+1,false, i);
                }
            }
        }
        else{
            for(int i=0;i<=9;i++){
                int num = number*10 +i;
                if(isPrime(num)){
                    generatePrime(n,resultArray,numlen+1,false,num);
                }
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

