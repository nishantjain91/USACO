/*
ID: nishant59
LANG: JAVA
TASK: preface
*/


import java.io.*;


public class preface {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("preface.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(reader.readLine());

        int[] count = new int[7];
        char[] arr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        for (int i = 1; i <= num; i++) {
            String s = roman(i);
            for (int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'I':
                        count[0]++;
                        break;
                    case 'V':
                        count[1]++;
                        break;
                    case 'X':
                        count[2]++;
                        break;
                    case 'L':
                        count[3]++;
                        break;
                    case 'C':
                        count[4]++;
                        break;
                    case 'D':
                        count[5]++;
                        break;
                    case 'M':
                        count[6]++;
                        break;
                }
            }

        }

        for (int i = 0; i < 7; i++) {
            if (count[i] != 0)
                writer.println(arr[i] + " " + count[i]);
        }
        writer.close();
        reader.close();
    }

    private static String roman(int num) {
        char[] arr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int ind = 0;
        StringBuffer m = new StringBuffer();
        StringBuffer fin = new StringBuffer();
        while (num > 0) {
            int a = num % 10;
            if (a > 0) {
                m.setLength(0);
                if (a < 4) for (int i = 0; i < a; i++) m.append(arr[ind]);
                else if (a == 4) {
                    m.append(arr[ind]);
                    m.append(arr[ind + 1]);
                } else if (a == 5) m.append(arr[ind + 1]);
                else if (a > 5 && a <= 8) {
                    m.append(arr[ind + 1]);
                    for (int i = 0; i <  a -5 ; i++) m.append(arr[ind]);
                } else {
                    m.append(arr[ind]);
                    m.append(arr[ind + 2]);
                }
                fin.insert(0, m);
            }
            num /= 10;
            ind += 2;
        }
        return fin.toString();
    }


}

