/*
ID: nishant59
LANG: JAVA
TASK: wormhole
*/


import java.io.*;
import java.util.StringTokenizer;

public class wormhole {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int numOfWormholes = Integer.parseInt(reader.readLine());

        int[] X = new int[numOfWormholes];
        int[] Y = new int[numOfWormholes];
        int[] nextOnRight = new int[numOfWormholes];
        int[] pairs = new int[numOfWormholes];

        for(int i=0;i<numOfWormholes;i++){
            pairs[i] =-1;
            nextOnRight[i]=-1;
        }

        for (int i = 0; i < numOfWormholes; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            X[i] = Integer.parseInt(stringTokenizer.nextToken());
            Y[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i=0; i<numOfWormholes; i++)
            for (int j=0; j<numOfWormholes; j++)
                if (X[j] > X[i] && Y[i] == Y[j])
                    if (nextOnRight[i] == -1 ||
                            X[j]-X[i] < X[nextOnRight[i]]-X[i])
                        nextOnRight[i] = j;

        int result = combinations(X,Y,numOfWormholes,pairs,nextOnRight);

        writer.println(result);
        writer.close();
        reader.close();

    }

    private static int combinations(int[] X, int[] Y, int numOfWormholes, int[] pairs, int[] nextOnRight) {

        int total=0;
        int i, j;
        for (i = 0; i < numOfWormholes; i++) {
            if (pairs[i] == -1) break;
        }

        if(i>=numOfWormholes){
            if(checkcycle(X,Y,numOfWormholes,pairs,nextOnRight))return 1;
            else return 0;
        }

        for (j = i + 1; j < numOfWormholes; j++) {
            if (pairs[j] == -1) {
                pairs[i] = j;
                pairs[j] = i;
                total+=combinations(X, Y, numOfWormholes, pairs,nextOnRight);
                pairs[i] = -1;
                pairs[j] = -1;
            }
        }
        return total;
    }

    private static boolean checkcycle(int[] X, int[] Y, int numOfWormholes, int[] pairs, int[] next_on_right) {

        for(int i=0;i<numOfWormholes;i++){
            int start = i;
            for(int j=0;j<numOfWormholes&& start !=-1;j++){
                start = next_on_right[pairs[start]];
            }
            if(start!= -1)return true;
        }
        return false;

    }

}
