//Prims Algorithm Program
//Lanke Gauri Arvind   SY-B   149

import java.util.Scanner;
import java.util.Arrays;

public class Prims {
    static void prim(int cost[][] ,int v){
        int mincost=0;
        int edge_count=1;
        boolean[] Visited = new boolean[v];
        Arrays.fill(Visited,false);
        Visited[0]=true;

        while(edge_count<v){
            int INF=99;
            int min =INF;
            int x=0;
            int y=0;
            for(int p=0;p<v;p++){
                if(Visited[p]==true){
                    for(int q=0;q<v;q++){
                        if(Visited[q] != true && min>cost[p][q]) {
                            min = cost[p][q];
                            x = p;
                            y = q;
                          }
                      }
                   }
              }
               Visited[y]=true;
                System.out.printf("Edge (%d, %d) with cost %d\n", x, y, min);
                mincost +=cost[x][y];
                edge_count++;
            }
            System.out.println("cost is :"+mincost);
        }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number of vertices:");
        int v=sc.nextInt();
        System.out.println("Enter the matrix");
        int INF=99;
        int cost[][]=new int[v][v];
        for(int p=0;p<v;p++){
            for(int q=0;q<v;q++){
                cost[p][q]=sc.nextInt();
              }
        }
        prim(cost,v);
    }
}