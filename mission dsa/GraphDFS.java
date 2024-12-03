//DFS Algorithm Program
//Lanke Gauri Arvind   SY-B  149

import java.io.*;
import java.util.*;

class GraphDFS {

    int v;
    LinkedList<Integer> adj[];
    Stack<Integer> s;

    GraphDFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        s = new Stack<Integer>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int a) {
        boolean nodes[] = new boolean[v];
        nodes[a] = true;
        s.push(a);
        while (s.size() != 0) {
            int c = s.pop();
            System.out.println("Element Dequed Is:" + c);
            for (int i = 0; i < adj[c].size(); i++) {
                int x = adj[c].get(i);
                if (!nodes[x]) {
                    nodes[x] = true;
                    s.push(x);
                }
            }
        }
    }

    public static void main(String args[]) {

        GraphDFS g = new GraphDFS(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.DFS(0);

    }
}