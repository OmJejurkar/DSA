//Lanke Gauri Arvind SY-B 149
//Priority Queue Program

import java.util.*;

class PriorityQueue{
    static int size=-1;
        
    static int H[]=new int[50];

    static int parent(int i){
        return (i-1)/2;
    }

    static int leftChild(int i){
        return (2*i)+1;
    }

    static int rightChild(int i){
        return (2*i)+2;
    }

    static void insert(int p){
        size=size+1;
        H[size]=p;
        shiftUp(size);
    }

    static void shiftUp(int i){
        while(i>0 && H[parent(i)]<H[i]){
            swap(parent(i),i);
            i=parent(i);
        }
    }

    static void swap(int i,int p){
        int temp=H[i];
        H[i]=H[p];
        H[p]=temp;
    }

    static int getMax(){
        return H[0];
    }

    static void display(){
                if(size==-1){
                    System.out.println("\nQueue is empty");
                }
                else{
		    System.out.println("\nPriority Queue: ");
                    for(int j=0;j<=size;j++){
                        System.out.println(H[j]+" ");
                    }
                    System.out.println(" ");
                }
     }

    static int extractMax(){
	 int result=H[0];
	 H[0]=H[size];
	 size=size-1;
	 shiftDown(0);
	 return result;
    }

    static void shiftDown(int i){
	 int maxIndex=i;
	 int l=leftChild(i);
	 int r=rightChild(i);
	 if(l<=size && H[l]>H[maxIndex]){
	       maxIndex=l;
	 }
	 if(r<=size && H[r]>H[maxIndex]){
	       maxIndex=r;
	 }
	 if(i!=maxIndex){
	      swap(i,maxIndex);
	      shiftDown(maxIndex);
	 }
    }

    static void remove(int i){
         H[i]=getMax()+1;
	 shiftUp(i);
	 extractMax();
     }

   static void changePriority(int i,int p)
    {
	int oldp = H[i];
  	H[i] = p;

  	if (p > oldp) 
  	{
    		shiftUp(i);
  	}
  	else 
  	{
    		shiftDown(i);
  	}
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size=sc.nextInt();
        
        int ch;

        do{
            System.out.println("\nChoose the operation: \n1.Insert \n2.Display\n3.Extract Max\n4.Remove\n5.Change Priority");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                System.out.println("\nEnter elements to insert ");
                for(int i=0;i<size;i++){
                    int e=sc.nextInt();
                    insert(e);
                }
                break;

                case 2:
                display();
                break;

                case 3:
                System.out.println("\nMax Element in Queue is: "+getMax());
                break;
		
		case 4:
		System.out.println("\nEnter the index to delete: ");
		int relement=sc.nextInt();
		if(relement>=0 && relement<=size)
		{
		     remove(relement);
		     System.out.println("Element removed successfully");
		}
		else{
		    System.out.println("Invalid index");
		}
		break;

		case 5:
		System.out.println("Enter the index to change priority: ");
		int index=sc.nextInt();
		System.out.println("Enter the new Key: ");
		int newKey=sc.nextInt();
		changePriority(index,newKey);
		break;
		

                default:
                System.out.println("\nInvalid Choice");
                break;
            }

            System.out.println("\nWant to Continue 1.Yes 0.No");
            ch=sc.nextInt();
        }while(ch==1);
    }
}


