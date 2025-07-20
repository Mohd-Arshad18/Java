import java.util.*;
public class Main {
    
    public static void frequency(int[] arr){
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int key: arr){
            freq.put(key,0);
        }
        for(int key: arr){
            if(freq.get(key) != 0){
                int f = freq.get(key);
                freq.put(key,f+1);
            }else{
                freq.put(key,1);
            }
        }
        System.out.println(freq);
    }
    
    public static void largestSequence(int[] arr){
        HashMap<Integer,Boolean> fmap = new HashMap<>();
        for(int key: arr){
            fmap.put(key,true);
        }
        for(int key: arr){
            if(fmap.containsKey(key-1)){
                fmap.put(key,false);
            }
        }
        int msp = 0;
        int ml = 0;
        for(int key: arr){
            if(fmap.get(key) == true){
                int tl = 1;
                int tsp = key;
                
                while(fmap.containsKey(tsp + tl)){
                    tl++;
                }
                if(tl > ml){
                    msp = tsp;
                    ml = tl;
                }
            }
        }
        System.out.println("Number = " + msp + " \nLength = " + ml);
    }
    
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,8,9,11,12,10,7,15,18,17};
        //largestSequence(arr);
        int[] arr2 = {1,1,1,1,2,2,2,3,3,4,4,4,5,6,7,6,7,8,8,9,19};
        frequency(arr2);
    }
    
}