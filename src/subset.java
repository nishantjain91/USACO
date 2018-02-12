/*
ID: nishant59
LANG: JAVA
TASK: subset
*/


import java.io.*;

public class subset {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("subset.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(reader.readLine());

        int sum = ((n*(n+1)/2));
        if(sum%2==1){
            writer.println(0);
        }else{
            sum = sum/2;
            long[][] dp = new long[n+1][sum+1];
            for(int i=0;i<=n;i++)
                for(int j=0;j<= sum;j++)
                    dp[i][j]= -1;
            writer.println(generateAnswers(n ,sum,dp)/2);

        }

        writer.close();
        reader.close();
    }

    private static  long generateAnswers(int n,  int sum, long [][] dp){
        if(sum<0)return 0;
        if(sum==0)return 1;
        if(n<1)return 0;

        if(dp[n][sum]!= -1) return dp[n][sum];

        dp[n][sum] =  generateAnswers(n-1, sum-n,dp) + generateAnswers(n-1,sum,dp);
        return dp[n][sum];


    }


}

