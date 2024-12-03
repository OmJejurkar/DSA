import java.util.*;

class Node{
	int data;
	Node left,right;
	public Node(int data){
		this.data=data;
		left=right=null;
	}
}
class Binary{
	Node root;
	
	public void insert(int data){
		Node newNode=new Node(data);
		if(root==null){
			root=newNode;
		}
		else{
			whereToInsert(root,newNode);
		}
	}

	public void whereToInsert(Node curNode,Node newNode){
		Scanner sc=new Scanner(System.in);
		int ch;
		do{
			System.out.println("Where to insert 1.Left 2.Right");
			int b=sc.nextInt();
			if(b==1){
				if(curNode.left==null){
					curNode.left=newNode;
					break;
				}
				curNode=curNode.left;
			}
			else if(b==2){
				if(curNode.right==null){
					curNode.right=newNode;
					break;
				}
				curNode=curNode.right;
			}
			else{
				System.out.println("Invalid Choice");
			}
			System.out.println("Want to continue 1.Yes 0.No");
			ch=sc.nextInt();
		}while(ch==1);
	}

	public void display(){
		System.out.println("Inorder traveral:");
		inOrder(root);
	}

	public void inOrder(Node root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	public int count_nodes(Node root){
		if(root==null){
			return 0;
		}
		else
		{
			int count=1;
			count+=count_nodes(root.left);
			count+=count_nodes(root.right);
			return count;
		}
	}

	public void print_leaves(Node root){
		if(root==null){
			return;
		}
		if(root.left==null && root.right==null){
			System.out.println(root.data);
		}
		print_leaves(root.left);
		print_leaves(root.right);
	}

	public int count_leaves(Node root){
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		return count_leaves(root.left)+count_leaves(root.right);
	}

	public int height(Node root)
	{
		if(root==null){
			return 0;
		}
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		if(leftHeight>rightHeight)
		{
			return leftHeight+1;
		}
		else{
			return rightHeight+1;
		}
	}
}

public class BinaryTree{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int ch;
		Binary b=new Binary();
		do{
			System.out.println("Enter your choice 1.Insert 2.Display 3.Count Nodes 4.Print Leaves 5.Count Leaves 6.Max Height");
			int choice=sc.nextInt();
			switch(choice){
				case 1:
				System.out.println("Enter the element you want to insert");
				int e=sc.nextInt();
				b.insert(e);
				break;
				
				case 2:
				System.out.println("Display elements ");
				b.display();
				break;

				case 3:
				System.out.println("Count of Nodes:"+b.count_nodes(b.root));
				break;

				case 4:
				System.out.println("Printing Leaves ");
				b.print_leaves(b.root);
				break;

				case 5:
				System.out.println("Count of Leaves:"+b.count_leaves(b.root));
				break;

				case 6:
				System.out.println("Max Height of tree:"+b.height(b.root));
				break;

				default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Want to continue 1.Yes 0.No");
			ch=sc.nextInt();
		}while(ch==1);
	}
}