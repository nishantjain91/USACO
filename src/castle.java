/*
ID: nishant59
LANG: JAVA
TASK: castle
*/


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class castle {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("castle.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[][] values = new int[n][m];
        int[][] comp = new int[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++)
                values[i][j] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[][][] neighbours = new int[n][m][4];
        neighbors(values, neighbours, n, m);

        boolean[][] visited = new boolean[n][m];

        int[][] size = new int[n][m];
        int com = 1;
        int maxArea = 0;
        int rooms = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    LinkedList<Integer> xnode = new LinkedList<>();
                    LinkedList<Integer> ynode = new LinkedList<>();
                    rooms++;
                    int connected = dfsGraph(visited, size, neighbours, i, j, xnode, ynode);
                    for (int k = 0; k < xnode.size(); k++) {
                        size[xnode.get(k)][ynode.get(k)] = connected;
                        comp[xnode.get(k)][ynode.get(k)] = com;
                    }
                    com++;
                    if (maxArea < connected) maxArea = connected;
                }
            }
        }

        int newMaxArea = 0;
        int x1 = 0, y1 = 0;
        char direction = 'a';

        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (neighbours[i][j][0] == 1) {
                    int nextx = i + 1;
                    int nexty = j;
                    if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && comp[i][j] != comp[nextx][nexty]) {
                        int area = size[i][j] + size[nextx][nexty];
                        if (area > newMaxArea) {
                            newMaxArea = area;
                            x1 = i + 1;
                            y1 = j + 1;
                            direction = 'S';
                        }
                    }
                }



                if (neighbours[i][j][2] == 1) {
                    int nextx = i - 1;
                    int nexty = j;
                    if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && comp[i][j] != comp[nextx][nexty]) {
                        int area = size[i][j] + size[nextx][nexty];
                        if (area > newMaxArea) {
                            newMaxArea = area;
                            x1 = i + 1;
                            y1 = j + 1;
                            direction = 'N';
                        }
                    }
                }

                if (neighbours[i][j][1] == 1) {
                    int nextx = i;
                    int nexty = j + 1;
                    if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && comp[i][j] != comp[nextx][nexty]) {
                        int area = size[i][j] + size[nextx][nexty];
                        if (area > newMaxArea) {
                            newMaxArea = area;
                            x1 = i + 1;
                            y1 = j + 1;
                            direction = 'E';
                        }
                    }
                }

                if (neighbours[i][j][3] == 1) {
                    int nextx = i;
                    int nexty = j - 1;
                    if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && comp[i][j] != comp[nextx][nexty]) {
                        int area = size[i][j] + size[nextx][nexty];
                        if (area > newMaxArea) {
                            newMaxArea = area;
                            x1 = i + 1;
                            y1 = j + 1;
                            direction = 'W';
                        }
                    }
                }


            }
        }

        writer.println(rooms);
        writer.println(maxArea);
        writer.println(newMaxArea);
        writer.println(x1 + " " + y1 + " " + direction);

        writer.close();
        reader.close();

    }

    private static int dfsGraph(boolean[][] visited, int[][] size, int[][][] neighbours, int n, int m, Queue<Integer> xnode, Queue<Integer> ynode) {
        if (visited[n][m]) return 0;
        visited[n][m] = true;
        xnode.add(n);
        ynode.add(m);

        int ans = 1;
        if (neighbours[n][m][0] == 0)
            ans += dfsGraph(visited, size, neighbours, n + 1, m, xnode, ynode);
        if (neighbours[n][m][1] == 0)
            ans += dfsGraph(visited, size, neighbours, n, m + 1, xnode, ynode);
        if (neighbours[n][m][2] == 0)
            ans += dfsGraph(visited, size, neighbours, n - 1, m, xnode, ynode);
        if (neighbours[n][m][3] == 0)
            ans += dfsGraph(visited, size, neighbours, n, m - 1, xnode, ynode);

        return ans;


    }

    private static void neighbors(int[][] values, int[][][] neighbours, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (values[i][j] > 7) {
                    neighbours[i][j][0] = 1;
                    values[i][j] -= 8;
                }
                if (values[i][j] > 3) {
                    neighbours[i][j][1] = 1;
                    values[i][j] -= 4;
                }
                if (values[i][j] > 1) {
                    neighbours[i][j][2] = 1;
                    values[i][j] -= 2;
                }
                if (values[i][j] > 0) {
                    neighbours[i][j][3] = 1;
                    values[i][j] -= 1;
                }
            }
        }
    }

}
