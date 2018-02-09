/*
ID: nishant59
LANG: JAVA
TASK: holstein
*/


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class holstein {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int numOfVitamins = Integer.parseInt(reader.readLine());
        int[] vitamins = new int[numOfVitamins];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        for(int i=0;i<numOfVitamins;i++){
            vitamins[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int numOfFeeds = Integer.parseInt(reader.readLine());
        int[][] feeds = new int[numOfFeeds][numOfVitamins];

        for(int i=0;i<numOfFeeds;i++){
            stringTokenizer = new StringTokenizer(reader.readLine());
            for(int j=0;j<numOfVitamins;j++){
                feeds[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[] vitaminsadded = new int[numOfVitamins];

        ArrayList<Integer> result = new ArrayList<>();
        result = minFeed(numOfVitamins,numOfFeeds,vitamins,feeds,result, new ArrayList<Integer>(),0,vitaminsadded);

        writer.print(result.size());

        for(int i=0;i<result.size();i++){
            writer.print(" " + (result.get(i)+1));
        }
        writer.println();

        writer.close();
        reader.close();

    }

    private static ArrayList<Integer> minFeed(int numOfVitamins, int numOfFeeds, int[] vitamins, int[][] feeds, ArrayList<Integer> ans, ArrayList<Integer> parans, int index, int[] vitamisadded){

        int answer = 1;
        for(int i=0;i<numOfVitamins;i++){
            if(vitamisadded[i]<vitamins[i]){
                answer=0;
                break;
            }
        }
        if(answer==1){
            if(ans.size()== 0 || parans.size() < ans.size()){
                ans = (ArrayList<Integer>) parans.clone();
            }
        }
        if(index  == numOfFeeds) return ans;

        for(int i=0;i<numOfVitamins;i++){
            vitamisadded[i]+=feeds[index][i];
        }
        parans.add(index);
        ans = minFeed(numOfVitamins,numOfFeeds,vitamins,feeds,ans,parans,index+1,vitamisadded);
        for(int i=0;i<numOfVitamins;i++){
            vitamisadded[i]-=feeds[index][i];
        }
        parans.remove(parans.size()-1);
        ans = minFeed(numOfVitamins,numOfFeeds,vitamins,feeds,ans,parans,index+1,vitamisadded);

        return ans;
    }
}
