/*
ID: nishant59
LANG: JAVA
TASK: crypt1
*/


import java.io.*;
import java.util.StringTokenizer;


public class crypt1 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int[] digits = new int[10];

        int numOfDigits = Integer.parseInt(reader.readLine());
        int[] digitsAvaiable = new int[numOfDigits];

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numOfDigits; i++) {
            int n = Integer.parseInt(stringTokenizer.nextToken());
            digitsAvaiable[i] = n;
            digits[n] = 1;
        }
        int total=0;
        int a,b,c,d,e=0;

        for (int i = 0; i < numOfDigits; i++) {
            if(digitsAvaiable[i]==0)continue;
            a = digitsAvaiable[i];
            for (int j = 0; j < numOfDigits; j++) {
                b=digitsAvaiable[j];
                for (int k = 0; k < numOfDigits; k++) {
                    c = digitsAvaiable[k];
                    for (int l = 0; l < numOfDigits; l++) {
                        if(digitsAvaiable[l]==0)continue;
                        d = digitsAvaiable[l];
                        for (int m = 0; m < numOfDigits; m++) {
                            e = digitsAvaiable[m];
                            int top = a*100 +b*10 +c;
                            int ps1 = top*e;
                            int ps2 = top*d;
                            if(check(ps1,digits) && check(ps2,digits)&&check1(ps2*10+ps1,digits)){
                                total++;
                            }
                        }
                    }
                }
            }
        }

        writer.println(total);
        writer.close();
        reader.close();

    }

    private static  boolean check(int num, int[] digits){
        String s = String.valueOf(num);
        if(s.length()==1 && digits[0]==1)return true;
        if(s.length()!=3)return false;
        for(int i=0;i<s.length();i++){
            if(digits[s.charAt(i)-'0']==0)return false;
        }
        return true;
    }

    private static  boolean check1(int num, int[] digits){
        String s = String.valueOf(num);
        for(int i=0;i<s.length();i++){
            if(digits[s.charAt(i)-'0']==0)return false;
        }
        return true;
    }

}
