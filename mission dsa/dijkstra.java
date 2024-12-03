//Dijkstra Algorithm Program
//Lanke Gauri Arvind   SY-B   149

import java.util.*;

public class dijkstra {
    static final int vertices = 5;

    int minimumDistance(int distance[], boolean vis[]) {
        int m = Integer.MAX_VALUE, m_index = -1;
        for (int i = 0; i < vertices; i++) {
            if (vis[i] == false && distance[i] <= m) {
                m = distance[i];
                m_index = i;
            }
        }
        return m_index;
    }

    void printSolution(int distance[], int n) {
        System.out.println("The shortest distance from source is:");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + " shortest distance is " + distance[i]);
        }
    }

    public void dijkstras(int mat[][], int s) {
        int distance[] = new int[vertices];
        boolean visited[] = new boolean[vertices];

        for (int j = 0; j < vertices; j++) {
            distance[j] = Integer.MAX_VALUE;
            visited[j] = false;
        }
        distance[s] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            int ux = minimumDistance(distance, visited);
            visited[ux] = true;

            for (int vx = 0; vx < vertices; vx++) {
                if (!visited[vx] && mat[ux][vx] != -1 && distance[ux] != Integer.MAX_VALUE && distance[ux] + mat[ux][vx] < distance[vx]) {
                    distance[vx] = distance[ux] + mat[ux][vx];
                }
            }
        }
        printSolution(distance, vertices);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int v = in.nextInt();
        System.out.println("Enter the matrix:");
        int mat[][] = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                mat[i][j] = in.nextInt();
            }
        }
        dijkstra obj = new dijkstra();
        obj.dijkstras(mat, 0);
    }
}
