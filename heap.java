import java.util.*;
public class Main {
    
    public static void order(int[] arr){
        int k = new Scanner(System.in).nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        
        for (int i = k; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = {1,2,3,5,7,67,46,95,25,34,45,11,10};
        
        for(int val: arr){
            pq.add(val);
        }
        /*for(int i = 0 ;i < pq.size(); i++){
            System.out.println(pq.peek());
            pq.remove();
        }*/
        //order(arr);
    }
    
}