/*
ID: nishant59
LANG: JAVA
TASK: combo
*/


import java.io.*;
import java.util.StringTokenizer;


public class combo {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("combo.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] locks = new int[6][n];

        StringTokenizer stringToken = new StringTokenizer(reader.readLine());

        for(int i=0;i<3;i++){
            int num = Integer.parseInt(stringToken.nextToken())-1;
            locks[i][num]=1;
            int copy = num;
            for(int j=1;j<3;j++){
                copy++;
                if(copy+1>n){
                    copy = 0;
                }
                locks[i][copy]=1;
            }
            copy = num;
            for(int j=1;j<3;j++){
                copy--;
                if(copy<0){
                    copy = n-1;
                }
                locks[i][copy]=1;
            }
        }

        stringToken = new StringTokenizer(reader.readLine());

        for(int i=3;i<6;i++){
            int num = Integer.parseInt(stringToken.nextToken())-1;
            locks[i][num]=1;
            int copy = num;
            for(int j=1;j<3;j++){
                copy++;
                if(copy+1>n){
                    copy = 0;
                }
                locks[i][copy]=1;
            }
            copy = num;
            for(int j=1;j<3;j++){
                copy--;
                if(copy<0){
                    copy = n-1;
                }
                locks[i][copy]=1;
            }
        }
        int[] anum = new int[3];
        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                if(locks[i][j]==1)
                    anum[i]++;
            }
        }

        int totlacount = 0;
        int count = 1;
        for(int j=0;j<3;j++)
            count *=anum[j];
        totlacount+=count;
        anum[0]=0;
        anum[1]=0;
        anum[2]=0;
        count=1;
        for(int i=3;i<6;i++){
            for(int j=0;j<n;j++){
                if(locks[i][j]==1)
                    anum[i-3]++;
            }
        }
        for(int j=0;j<3;j++)
            count *=anum[j];
        totlacount+=count;

        anum[0]=0;
        anum[1]=0;
        anum[2]=0;
        count=1;

        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                if(locks[i][j]==1 && locks[i+3][j]==1)
                    anum[i]++;
            }
        }
        for(int j=0;j<3;j++)
            count *=anum[j];
        totlacount-=count;

        writer.println(totlacount);

        writer.close();
        reader.close();

    }

}
