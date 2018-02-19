/*
ID: nishant59
LANG: JAVA
TASK: prefix
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class prefix {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        ArrayList<String>  primitive = new ArrayList<>();

        while(!s.equals(".")){
           String[] temp = s.split(" ");
           for(int i=0;i<temp.length;i++)
               primitive.add(temp[i]);
           s = reader.readLine();
        }

        Collections.sort(primitive, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                        return -1;
                else return 1;
            }
        });

        StringBuffer sequenceBuffer = new StringBuffer();

        while((s=reader.readLine())!=  null){
            sequenceBuffer.append(s);
        }
        boolean[] dp  = new boolean[sequenceBuffer.length()+1];

        for(int i=0;i<dp.length;i++)
            dp[i]=false;

        writer.println(maxPrefix(sequenceBuffer,primitive,0,sequenceBuffer.length()-1,dp));


        writer.close();
        reader.close();
    }

    private  static int maxPrefix(StringBuffer sequence, ArrayList<String> primitive, int start, int end, boolean[] dp){

        int max=0;
        dp[0] = true;
        for(int i=1;i<=sequence.length();i++){
            for(int j=0;j<primitive.size();j++){
                String pr = primitive.get(j);
                int length = pr.length();
                if(length <= i){
                    if(pr.equals(sequence.substring(i-length,i)) && dp[i-length]){
                        dp[i] =true;
                    }
                }
            }
            max = dp[i]?i:max;
        }
        return max;
    }

}

