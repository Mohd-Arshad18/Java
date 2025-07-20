import java.util.*;
public class Main {
    
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int xnh = power(x, n/2);
        int xn = xnh * xnh;
        
        if(n%2 == 1){
            return xn*x;
        }
        return xn;
    }
    
    public static void towerOfHanoi(int n, int t1id, int t2id, int t3id){
        if(n == 0){
            return;
        }
        towerOfHanoi(n-1 ,t1id ,t3id, t2id);
        System.out.println(n + "[" + t1id + " --> " + t2id + "]");
        towerOfHanoi(n-1, t3id, t2id, t1id);
    }
    
    public static void displayArr(int[] arr, int idx){
        if(idx == -1){
            return;
        }
        if(idx == arr.length){
            System.out.println("Invalid index");
            return;
        }
        displayArr(arr, idx-1);
        System.out.println(arr[idx]);
    }
    
    public static void displayArrRev(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        displayArrRev(arr, idx+1);
        System.out.println(arr[idx]);
    }
    
    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
    
        ArrayList<String> paths1 = getStairPaths(n - 1);
        ArrayList<String> paths2 = getStairPaths(n - 2);
        ArrayList<String> paths3 = getStairPaths(n - 3);
    
        ArrayList<String> paths = new ArrayList<>();
    
        for (String path : paths1) {
            paths.add(1 + path);
        }
        for (String path : paths2) {
            paths.add(2 + path);
        }
        for (String path : paths3) {
            paths.add(3 + path);
        }
    
        return paths;
    }
    
    public static void printStairPaths(int n, String path) {
        if (n < 0) {
            return;
        }

        if (n == 0) {
            System.out.println(path);
            return;
        }

        printStairPaths(n - 1, path + "1");
        printStairPaths(n - 2, path + "2");
        printStairPaths(n - 3, path + "3");
    }
    
    public static void printPermutation(String ques, String ans){
        
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        
        for(int i = 0; i < ques.length(); i++){
            char ch = ques.charAt(i);
            String qlpart = ques.substring(0,i);
            String qrpart = ques.substring(i+1);
            String ros = qlpart + qrpart;
            printPermutation(ros, ans + ch);
            
        }
    }
    
    public static void printtargetsumsubsets(int[] arr, int idx, String set, int sos, int tar){
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ".");
            }
            return;
        }
        
        printtargetsumsubsets(arr, idx + 1, set = arr[idx] + ",", sos + arr[idx],tar);
        printtargetsumsubsets(arr, idx + 1, set, sos, tar);
        
    }
    
    public static void main(String[] args) {
        System.out.println(power(2,6));
        int[] test = {10, 20, 30, 40, 50};
        //displayArr(test, 4);
        String ques = "abc";
        printPermutation(ques,"");
        
    }
    
}