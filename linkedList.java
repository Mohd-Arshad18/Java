import java.util.*;
public class LL {
    
    public static class node{
        int data;
        node next;
    }
    public static class LinkedList{
        node head;
        node tail;
        int size;
        
        public void addlast(int val){
            node temp = new node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        
        public void removefirst(){
            if(size == 0){
                System.out.println("Linked list is Empty.");
            }else if(size == 1){
                head = tail = null;
                size = 0;
            }else{
                head = head.next;
                size--;
            }
        }
        
        public int size(){
            return size;
        }
        
        public void display(){
            node temp = new node();
            temp = head;
            while(temp != null){
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.println("Null");
        }
        
        public int getFirst(){
            node temp = new node();
            temp = head;
            return temp.data;
        }
        
        public int getLast(){
            node temp = new node();
            temp = tail;
            return temp.data;
        }
        
        public int getAt(int idx){
            node temp = new node();
            temp = head;
            if(idx < 0 || idx >= size){
                System.out.println("Invalid index.");
                return -1;
            }else{
                for(int i = 0; i < idx; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }
        
        public void addFirst(int val){
            node temp = new node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }
            size++;
        }
        
        public void removeLast(){
            node temp = new node();
            if(size == 0){
                System.out.println("List is empty.");
            }else if(size == 1){
                head = temp = null;
                size--;
            }else{
                temp = head;
                while(temp.next.next != null){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
            }
        }
        
        public void addAt(int val, int idx){
            node temp = new node();
            temp.data = val;
            temp.next = null;
            node dum = new node();
            if(idx < 0 || idx > size){
                System.out.println("Invalid index.");
            }else{
                dum = head;
                for(int i = 0; i < idx - 1; i++){
                    dum = dum.next;
                }
                temp.next = dum.next;
                dum.next = temp;
                size++;
            }
        }
        
        public void removeAt(int idx){
            if(idx < 0 || idx >= size){
                System.out.println("Invalid index.");
                return;
            }
            if(idx == 0){
                removefirst();
                return;
            }
            node temp = head;
            for(int i = 0; i < idx - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(idx == size - 1){
                tail = temp;
            }
            size--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        LinkedList list = new LinkedList();
        
        list.addlast(10);
        list.addlast(20);
        list.addlast(30);
        list.display();
        
        list.addFirst(0);
        list.display();
        
        list.addAt(5, 1);
        list.display();
        
        list.removeAt(1);
        list.display();
        System.out.println(list.size());
        
    }
}