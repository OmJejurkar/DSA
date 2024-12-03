
//HeapSort Program
//Lanke Gauri Arvind  SY-B  149

import java.util.*;
import java.util.Scanner;

class heapSort{
    static void sortAscending(int arr[]){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify1(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify1(arr,i,0);
        }
    }

    static void heapify1(int arr[],int n,int i){
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n && arr[l]>arr[largest]){
            largest=l;
        }
        if(r<n && arr[r]>arr[largest]){
            largest=r;
        }
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify1(arr,n,largest);
        }
    }

    static void sortDescending(int arr[]){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify2(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify2(arr,i,0);
        }
    }

    static void heapify2(int arr[],int n,int i){
        int smallest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n && arr[l]<arr[smallest]){
            smallest=l;
        }
        if(r<n && arr[r]<arr[smallest]){
            smallest=r;
        }
        if(smallest!=i){
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            heapify2(arr,n,smallest);
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the array: ");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Want to swap using 1.MaxHeap or 2.MinHeap");
        int ch=sc.nextInt();
        if(ch==1){
            sortAscending(arr);
        }
        else if(ch==2){
            sortDescending(arr);
        }

        System.out.println("Sorted array is ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+"  ");
        }
    }
}