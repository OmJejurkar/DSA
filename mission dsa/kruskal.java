//Kruskal Algorithm Program
//Lanke Gauri Arvind   SY-B   149

import java.util.*;

class kruskal{
   static int INF=999;
   static int parent[];
   public kruskal(int v){
      parent=new int[v];
      for(int i=0;i<v;i++){
         parent[i]=i;
      }
   }

   static int find(int i){
      while (parent[i]!=i){
         i=parent[i];
      }
      return i;
   }

   static void union(int i,int j){
      int a=find(i);
      int b=find(j);
      parent[a]=b;
   }

   static void kruskalMST(int cost[][]){
      int mincost=0;
      int v=cost.length;
      for(int k=0;k<v-1;k++){
         int min=INF,a=-1,b=-1;
         for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
               if(find(i)!=find(j) && cost[i][j]<min){
                  min=cost[i][j];
                  a=i;
                  b=j;
               }
            }
         }
         union(a,b);
         System.out.println("Edge "+a+"-"+b+" :cost="+min);
         mincost+=min;
      }
   System.out.println("Minimum cost of Spanning Tree= "+mincost);
   }

   public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the no. of vertices ");
        int v=s.nextInt();
        int cost[][]=new int[v][v];
        System.out.println("Enter the weighted matrix: ");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                cost[i][j]=s.nextInt();
            }
        }
        kruskal kru=new kruskal(v);
        kru.kruskalMST(cost);
    }
}