import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(10);
        list.add(25);
        list.add(30);
        list.add(40);
        System.out.println(list);
        list.set(1, 20);
        list.add(1, 15);
        System.out.println(list);
        System.out.println(list.size());
        
    }
    
}