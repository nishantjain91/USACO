/*
ID: nishant59
LANG: JAVA
TASK: milk3
*/


import java.io.*;
import java.util.StringTokenizer;


public class milk3 {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));


        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        boolean[][][] visited = new boolean[a+1][b+1][c+1];
        int[] result = new int[c+1];
        dfs(visited,result,0,0,c,a,b,c);

        int first = 0;
        for(int i=0;i<result.length;i++){
            if(result[i]==1){
                if(first!=0){
                    writer.write(" ");
                }
                writer.print(i);
                first=1;
            }
        }
        writer.println();


        writer.close();
        reader.close();

    }

    private static void dfs(boolean[][][] visited, int[] result, int a , int b, int c, int atotal, int btotal, int ctotal){
        if(visited[a][b][c]) return;
        visited[a][b][c] = true;
        if(a==0)result[c] = 1;

        int pouredcb = pour(c,b,ctotal,btotal);
        c = c-pouredcb;
        b = b+pouredcb;
        dfs(visited,result,a,b,c,atotal,btotal,ctotal);
        c = c+pouredcb;
        b = b-pouredcb;

        int pouredca = pour(c,a,ctotal,atotal);
        c = c-pouredca;
        a = a+pouredca;
        dfs(visited,result,a,b,c,atotal,btotal,ctotal);
        c = c+pouredca;
        a = a-pouredca;

        int pouredbc = pour(b,c,btotal,ctotal);
        b = b-pouredbc;
        c = c+pouredbc;
        dfs(visited,result,a,b,c,atotal,btotal,ctotal);
        b = b+pouredbc;
        c = c-pouredbc;

        int pouredba = pour(b,a,btotal,atotal);
        b = b-pouredba;
        a = a+pouredba;
        dfs(visited,result,a,b,c,atotal,btotal,ctotal);
        b = b+pouredba;
        a = a-pouredba;

        int pouredac = pour(a,c,atotal,ctotal);
        a = a-pouredac;
        c = c+pouredac;
        dfs(visited,result,a,b,c,atotal,btotal,ctotal);
        a = a+pouredac;
        c = c-pouredac;

        int pouredab = pour(a,b,atotal,btotal);
        a = a-pouredab;
        b = b+pouredab;
        dfs(visited,result,a,b,c,atotal,btotal,ctotal);
        a = a+pouredab;
        b = b-pouredab;
    }

    private static int pour(int a, int b, int atotal, int btotal){
        int bcapacity = btotal - b;
        if(bcapacity>=a)return a;
        return bcapacity;
    }


}
