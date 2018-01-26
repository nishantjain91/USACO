/*
ID: nishant59
LANG: JAVA
TASK: namenum
*/


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class namenum {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        ArrayList<String> acceptablenames = new ArrayList<>();
        BufferedReader namereader = new BufferedReader(new FileReader("dict.txt"));
        int i=0;
        String n=namereader.readLine();
        while(n!= null ){
            acceptablenames.add(n);
            n=namereader.readLine();
        }

        String s = reader.readLine();
        String chars= "ABCDEFGHIJKLMNOPRSTUVWXY";
        HashMap<Character,Integer> map = new HashMap<>();
        int val = 1;
        for(i=0;i<chars.length();i++){
            if(i%3==0)
                val++;
            map.put(chars.charAt(i),val);
        }

        ArrayList<String> res = new ArrayList<>();
        createNumbers(acceptablenames,map,res,s);

        for(i=0;i<res.size();i++)
            writer.println(res.get(i));
        if(res.size()==0)
            writer.println("NONE");

        writer.close();
        reader.close();

    }

    private static void createNumbers(ArrayList<String> acceptableNames,HashMap<Character,Integer> map,ArrayList<String> res, String number){
        for (String name : acceptableNames) {
            if (name.length() == number.length()) {
                String namenumber = "";
                for (int j = 0; j < name.length(); j++) {
                    namenumber = namenumber + map.get(name.charAt(j));
                }
                if (namenumber.equals(number))
                    res.add(name);
            }
        }
    }


}
