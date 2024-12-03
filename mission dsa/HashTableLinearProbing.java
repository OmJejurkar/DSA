//Linear Probing using Hash Table
//Lanke Gauri Arvind  SY-B  149

import java.util.*;
import java.io.*;
import java.util.Scanner;

class LP {

    private int curSize, maxSize;
    private String[] keys;
    private String[] vals;

    public LP(int capacity) {
        curSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    public int hash(String k) {
        return Integer.parseInt(k) % maxSize;
    }

    public void insert(String k, String v) {
        int temp = hash(k);
        int i = temp;
        do {
            if (keys[i] == null) {
                keys[i] = k;
                vals[i] = v;
                curSize++;
                return;
            }
            if (keys[i].equals(k)) {
                vals[i] = v;
                return;
            }
            i = (i + 1) % maxSize;
        } while (i != temp);
    }

    public void display() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != null) {
                System.out.println(i+" "+keys[i] + " " + vals[i]);
            }
        }
    }

    public boolean isFull() {
        return curSize == maxSize;
    }

    public boolean isEmpty() {
        return maxSize== 0;
    }

    public String get(String k) {
        int i = hash(k);
        while (keys[i] != null) {
            if (keys[i].equals(k)) {
                return vals[i];
            }
            i = (i + 1) % maxSize;
        }
        return null;
    }

    public boolean contains(String k) {
        return get(k) != null;
    }

    public void makeEmpty() {
        curSize = 0;
        keys= new String[maxSize];
        vals= new String[maxSize];
    }

    public int getSize() {
        return curSize;
    }

    public void remove(String k) {
        if(!contains(k)){
            return;
        }
        int i=hash(k);
        while(!k.equals(keys[i])){
            i=(i+1)%maxSize;
        }
        keys[i]=vals[i]=null;
        for(i=(i+1)%maxSize;keys[i]!=null;i=(i+1)%maxSize){
            keys[i]=vals[i]=null;
            curSize--;
        }
        curSize--;
    }
}

public class HashTableLinearProbing{
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("HASH TABLE");
        System.out.println("Enter Size");
        LP l = new LP(s.nextInt());
        int b;

        do {
            System.out.println("\nEnter the operation you want to perform: 1.Insert\n 2.Remove\n 3.Get\n 4.Clear\n 5.Size\n");
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the key and value: ");
                    l.insert(s.next(), s.next());
                    break;

                case 2:
                    System.out.println("Enter the key: ");
                    l.remove(s.next());
                    System.out.println("Record Deleted Successfully");
                    break;

                case 3:
                    System.out.println("Enter the key: ");
                    System.out.println("The value of key is: "+ l.get(s.next()));
                    break;

                case 4:
                    l.makeEmpty();
                    System.out.println("Hash Table Cleared");
                    break;

                case 5:
                    System.out.println("The size of table is: " + l.getSize());
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
            l.display();
            System.out.println("\nWant to continue? (1.Yes 0.No) ");
            b = s.nextInt();

        } while (b==1);
    }
}