/*
ID: nishant59
LANG: JAVA
TASK: milk
*/


import java.io.*;
import java.util.StringTokenizer;


public class milk {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("milk.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringToken = new StringTokenizer(reader.readLine());
        int milkRequired = Integer.parseInt(stringToken.nextToken());
        int numOfFarmers = Integer.parseInt(stringToken.nextToken());

        int[] milkAvailable = new int[10001];
        for (int i = 0; i < numOfFarmers; i++) {
            stringToken = new StringTokenizer(reader.readLine());
            int price = Integer.parseInt(stringToken.nextToken());
            int amount = Integer.parseInt(stringToken.nextToken());
            milkAvailable[price] += amount;
        }

        long totalPrice = 0;

        for (int i = 0; i <= 1000 && milkRequired != 0; i++) {
            if (milkAvailable[i] > milkRequired) {
                totalPrice += milkRequired * i;
                milkRequired = 0;
            } else {
                totalPrice += milkAvailable[i] * i;
                milkRequired -= milkAvailable[i];
            }
        }

        writer.println(totalPrice);

        writer.close();
        reader.close();

    }

}
