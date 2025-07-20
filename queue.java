import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        Queue<Integer> Que = new ArrayDeque<Integer>();
        Que.add(10);
        Que.add(20);
        Que.add(30);
        Que.offer(40);
        Que.add(50);
        Que.remove();
        System.out.println(Que.peek());
        System.out.println(Que);
        System.out.println(Que.size());
    }
    
}