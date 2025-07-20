import java.util.*;
public class Main {
    
    public static int fibo(int n, int[] qb){
        if(n == 1 || n == 0){
            return n;
        }
        if(qb[n] != 0){
            return qb[n];
        }
        System.out.println("hello" + n);
        int fib1 = fibo(n-1, qb);
        int fib2 = fibo(n-2, qb);
        int ans = fib1 + fib2;
        
        qb[n] = ans;
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(fibo(10, new int[11]));
        
    }
    
}