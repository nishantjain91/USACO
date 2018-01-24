/*
ID: nishant59
LANG: JAVA
TASK: gift1
*/


import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class gift1 {

    public static void main (String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int numOfPeople = Integer.parseInt(reader.readLine());

        LinkedHashMap<String,Integer> people = new LinkedHashMap<>();

        for(int i=0;i<numOfPeople;i++){
            String person = reader.readLine();
            people.put(person,0);
        }

        String person;
        while((person = reader.readLine())!= null && person.length()!=0){
            StringTokenizer line = new StringTokenizer(reader.readLine());
            int money = Integer.parseInt(line.nextToken());
            int numPeople = Integer.parseInt(line.nextToken());
            int moneyPerPerson = (numPeople!=0)?money/numPeople:0;

            for(int i=0;i<numPeople;i++){
                String to = reader.readLine();
                people.put(to,people.get(to)+moneyPerPerson);
            }
            int moneyspent = moneyPerPerson * numPeople;
            people.put(person,people.get(person)-moneyspent);
        }

        for( Map.Entry<String,Integer> entry : people.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            writer.printf("%s %d\n",key,value);
        }

        writer.close();
        reader.close();

    }
}
