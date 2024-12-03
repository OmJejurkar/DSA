import java.io.*;
import java.util.*;

class GraphBFS
{
	int v;
	LinkedList<Integer> adj[];
	Queue<Integer> q;

	GraphBFS(int v){
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList<>();
		}
		q=new LinkedList<Integer>();
	}

	public void edge(int v,int w){
		adj[v].add(w);
	}

	public void BFS(int a){
		boolean nodes[]=new boolean[v];
		nodes[a]=true;
		q.add(a);
		while(q.size()!=0){
			int c=q.poll();
			System.out.println("Element dequeued is: "+c);
			for(int i=0;i<adj[c].size();i++){
				int x=adj[c].get(i);
				if(!nodes[x]){
					nodes[x]=true;
					q.add(x);
				}
			}
		}
	}
	public static void main(String args[]){
		GraphBFS g=new GraphBFS(5);
		g.edge(0,1);
		g.edge(0,2);
		g.edge(1,2);
		g.edge(1,4);
		g.edge(2,3);
		g.BFS(0);
	}
}