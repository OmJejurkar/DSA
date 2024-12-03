import java.util.*;

class Node{
 int data;
 char c;
 Node left,right;
}

class NodeComparator implements Comparator<Node>{
   public int compare(Node m,Node n){
      return m.data-n.data;
   }
}

public class Huffman1{
    public static void printCode(Node root,String s){
       if(root.right==null && root.left==null && Character.isLetter(root.c)){
          System.out.println(root.c+" : "+s);
          return;
       }
     if(root.left!=null){
       printCode(root.left,s+"0");
     }
    if(root.right!=null){
      printCode(root.right,s+"1");
     }
    }

   public static void main(String args[]){
       int size=5;
        char carr[]={'a','b','c','d','e'};
        int iarr[]={5,7,2,9,4};
        PriorityQueue<Node> q=new PriorityQueue<Node>(size,new NodeComparator());
        
       for(int i=0;i<size;i++){
            Node n=new Node();
            n.char=carr[i];
            n.data=iarr[i];
            n.left=null;
            n.right=null;
            q.add(n);
        }

        Node root=null;
 
       while(q.size()>1){
        Node mm=q.poll();
        Node nn=q.poll();
        Node p=new Node();
        p.data=mm.data+nn.data;
        p.c='-';
        p.left=mm;
        p.right=nn;
        root=p;
        q.add(p);f
       }

    root=q.poll();
    printCode(root,"");
    } 

}