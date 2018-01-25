/*
ID: nishant59
LANG: JAVA
TASK: transform
*/


import java.io.*;


public class transform {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("transform.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        char[][] patternbefore = new char[n][n];
        char[][] patternafter = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = reader.readLine();
            for (int j = 0; j < n; j++) {
                patternbefore[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String row = reader.readLine();
            for (int j = 0; j < n; j++) {
                patternafter[i][j] = row.charAt(j);
            }
        }

        int result = -1;

        for (int i = 0; i < 3; i++) {
            rotateMatrix(patternbefore, n);
            if (check(patternafter, patternbefore, n)) {
                result = i + 1;
                break;
            }
        }

        if (result == -1) {
            rotateMatrix(patternbefore, n);
            reflectMatrix(patternbefore, n);
            if (check(patternafter, patternbefore, n)) {
                result = 4;
            }
        }

        for (int i = 0; i < 3 && result == -1; i++) {
            rotateMatrix(patternbefore, n);
            if (check(patternafter, patternbefore, n)) {
                result = 5;
                break;
            }
        }

        if (result == -1) {
            rotateMatrix(patternbefore, n);
            reflectMatrix(patternbefore, n);
            if (check(patternafter, patternbefore, n)) {
                result = 6;
            }
        }

        if (result == -1) {
            result = 7;
        }


        writer.println(result);

        writer.close();
        reader.close();

    }

    private static void rotateMatrix(char[][] matrix, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                char temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n / 2; j++) {
                char temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
    }

    private static boolean check(char[][] matrix1, char[][] matrix2, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (matrix1[i][j] != matrix2[i][j])
                    return false;
            }
        return true;
    }

    private static void reflectMatrix(char[][] matrix, int n) {

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n / 2; j++) {
                char temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
    }

}
