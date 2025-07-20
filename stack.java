import java.util.*;

public class STACK {
  
  public static void printarr(int[] arr){
    for (int i =0; i<arr.length-1;i++){
      System.out.print( arr[i] + " ");
    }
  }
  public static void main (String[] args){
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Hey");
    
    int[] arr = new int[10];
    
    for (int i=0; i< arr.length-1;i++){
      arr[i]= sc.nextInt();
    }
    printarr(arr);
    
    Stack<Integer> st= new Stack<Integer>();
    
    st.push(3);
    st.push(4);
    st.push(2);
    st.push(8);
    st.push(9);
    System.out.println();
    System.out.print(st);
    st.pop();
    System.out.println();
    System.out.print(st);
    
  }
}