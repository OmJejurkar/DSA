import java.util.*;

class Node{
    int data;
    Node left,right;
    public Node(int data)
    {
       this.data=data;
       this.left=null; 
       this.right=null;
     }
}

class BST{
  Node root;

  public void insert(int data)
   {
       root=insertRec(root,data);
   }

  public Node insertRec(Node root,int data)
   {
       if(root==null){
          root=new Node(data);
          return root;
        }
      if(data<root.data){
        root.left=insertRec(root.left,data);
       }
      else if(data>root.data){
        root.right=insertRec(root.right,data);
      }
     return root;
   }
 
   public void display(){
       System.out.println("Display the elements in inoder traversal:");
       inOrder(root);
    }
   
    public void inOrder(Node root){
          if(root==null){
             return;
          }
        inOrder(root.left);
        System.out.println(" "+root.data);
      inOrder(root.right);
     }

     public void search(){
        Scanner sc=new Scanner(System.in);
         System.out.println("Enter the element you want to search");
        int s=sc.nextInt();
        if(search(root,s)){
            System.out.println("Element found");
          }
       else{
         System.out.println("Not found");
        }
     }
   public boolean search(Node root,int data){
       if(root==null){
           return false;
        }
      if(root.data==data){
          return true;
       }
      else if(data<root.data){
         return search(root.left,data);
       }
      else{
        return search(root.right,data);
        }
     }

   public int findMin(Node root){
      if(root==null){
        return 0;
       }
     while(root.left!=null){
        root=root.left;
      }
     return root.data;
   }
  
   public int findMax(Node root){
    if(root==null){
      return 0;
    }
   while(root.right!=null){
      root=root.right;
     }
  return root.data;
  }
   
  public Node deleteNode(Node root,int data){
      if(root==null){
         return root;
      }
    if(data<root.data){
       root.left=deleteNode(root.left,data);
    }
    else if(data>root.data){
     root.right=deleteNode(root.right,data);
     }
    else{
       if(root.left==null){
         return root.right;
        }
       else if(root.right==null){
         return root.left;
        }
      else{
       root.data=findMin(root.right);
       root.right=deleteNode(root.right,root.data);
       }
     }
   return root;  
  }

}

public class BinarySearchTree1
{
  public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       BST b=new BST();
       int repeat;
       do{
          System.out.println("Select operation: 1.Insert 2.Display 3.Search 4.Minimum 5.Maximum 6.Delete");
          int choice=sc.nextInt();
          switch(choice)
           {
               case 1:
               System.out.println("Enter the element to insert");
               int element=sc.nextInt();
                b.insert(element);
                break;
        
              case 2:
              b.display();
             break;

            case 3:
           b.search();
           break;
  
           case 4:
           System.out.println("Minimum value in BST is:"+b.findMin(b.root));
           break;

           case 5:
           System.out.println("Maximum value in BST is:"+b.findMax(b.root));
            break;

          case 6:
          System.out.println("Enter element to delete");
          int d=sc.nextInt();
          b.deleteNode(b.root,d);
          System.out.println("Element deleted Successfully");
           break;

          default:
         System.out.println("Invalid choice");
         break;
          }
          System.out.println("Want to continue? 1.Yes 0.No");
         repeat=sc.nextInt();
       }while(repeat==1);
    }
}