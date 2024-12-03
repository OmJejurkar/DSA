//Chaining without Replacement using HashTable
//Lanke Gauri Arvind  SY-B  149

import java.util.LinkedList;
import java.util.Scanner;
import java.security.Key;
import java.util.*;

class HashTable{
    private int size;
    private LinkedList<Integer>[] table;

    public HashTable(int size){
        this.size=size;
        table=new LinkedList[size];
        for(int i=0;i<size;i++){
            table[i]=new LinkedList<>();
        }
    }

    public int hash(int k) {
        return k % size;
    }

    public void insert(int key){
        int k=hash(key);
        table[k].add(key);
        System.out.println("Element inserted Successfully");
    }

    public void display(){
        for(int i=0;i<size;i++){
            System.out.print("Index "+i+" -> ");
            for(Integer key:table[i]){
                System.out.print(key+" -> ");
            }
        System.out.println("null");
        }
    }

    public boolean search(int key){
        int index=hash(key);
        return table[index].contains(key);
    }
}

public class chainingWithoutReplacement{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Hashtable: ");
        int size=sc.nextInt();

        HashTable ht=new HashTable(size);
        int ch;

        do{
            System.out.println("Choose the operation you want to perform :\n 1.Insert \n 2.Display \n 3.Search\n");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                System.out.println("Enter the number of keys you want to insert");
                int n=sc.nextInt();
                System.out.println("\nEnter the Keys");
                for(int i=0;i<n;i++){
                    int key=sc.nextInt();
                    ht.insert(key);
                }
                break;

                case 2:
                System.out.println("Hash Table: ");
                ht.display();
                break;

                case 3:
                System.out.println("Enter key you want to search for: ");
                int keyToSearch=sc.nextInt();
                if(ht.search(keyToSearch)){
                    System.out.println(keyToSearch+" is found in hash table");
                }
                else{
                    System.out.println(keyToSearch+" is not found in hash table");
                }
                break;

                default:
                System.out.println("Invalid choice");
                break;
            }
            System.out.println("\nWant to continue? 1.Yes 0.No");
            ch=sc.nextInt();
        }while(ch==1);
    }
}