import java.util.*;
public class Main {
    
    static Scanner sc = new Scanner(System.in);
    public static void arrmulti(){
        System.out.print("Enter number of rows of matrix 1:");
        int r1 = sc.nextInt();
        System.out.print("Enter number of columns of matrix 1:");
        int c1 = sc.nextInt();
        
        int[][] mat1 = new int[r1][c1];
        
        System.out.print("Enter values:");
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                mat1[i][j] = sc.nextInt();
            }
        }
        
        System.out.print("Enter number of rows of matrix 2:");
        int r2 = sc.nextInt();
        System.out.print("Enter number of columns of matrix 2:");
        int c2 = sc.nextInt();
        
        int[][] mat2= new int[r2][c2];
        
        System.out.print("Enter values:");
        for(int i = 0; i < r2; i++){
            for(int j = 0; j < c2; j++){
                mat2[i][j] = sc.nextInt();
            }
        }
        if(c1 == r2){
            System.out.println("Invalid input");
            return;
        }
        int[][] matmulti = new int[r1][c2];
        
        for(int i = 0; i < matmulti.length; i++){
            for(int j = 0; j < matmulti[0].length; j++){
                for(int k = 0; k < c1; k++){
                    matmulti[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        System.out.println("Array :");
        for(int i = 0; i < matmulti.length; i++){
            for(int j = 0; j < matmulti[0].length; j++){
                System.out.print(matmulti[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void wavetraversal(){
        System.out.print("Enter number of rows:");
        int r = sc.nextInt();
        System.out.print("Enter number of columns:");
        int c = sc.nextInt();
        
        int[][] mat = new int[r][c];
        
        System.out.print("Enter values:");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        
        for(int j = 0; j < mat[0].length; j++){
            if(j%2 == 0){
                for(int i = 0; i < mat.length; i++){
                    System.out.println(mat[i][j]);
                }
            }else{
                for(int i = mat.length; i >= 0; i--){
                    System.out.println(mat[i][j]);
                }
            }
        }
    }
    
    public static void spiralTraversal(){
        System.out.print("Enter number of rows:");
        int r = sc.nextInt();
        System.out.print("Enter number of columns:");
        int c = sc.nextInt();
        
        int[][] arr = new int[r][c];
        
        System.out.print("Enter values:");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int tne = arr.length * arr[0].length;
        int cnt = 0;
        
        while(cnt < tne){
            // left wall
            for(int i = minr, j = minc; i <= maxr && cnt < tne; i++){
                System.out.println(arr[i][j]);
                cnt++;
            }
            minc++;

            // bottom wall
           for(int i = maxr, j = minc; j <= maxc && cnt < tne; j++){
               System.out.println(arr[i][j]);
                cnt++;
           }
            maxr--;

            // right wall
           for(int i = maxr, j = maxc; i >= minr && cnt < tne; i--){
                System.out.println(arr[i][j]);
              cnt++;
           }
           maxc--;

           // top wall
          for(int i = minr, j = maxc; j >= minc && cnt < tne; j--){
               System.out.println(arr[i][j]);
               cnt++;
          }
            minr++;
        }       
    }
    
    public static void exitPoint(){
        System.out.print("Enter number of rows:");
        int r = sc.nextInt();
        System.out.print("Enter number of columns:");
        int c = sc.nextInt();
        
        int[][] arr = new int[r][c];
        
        System.out.print("Enter values:");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int i = 0, j = 0;
        int dir = 0;
    
        while (true) {
            dir = (dir + arr[i][j]) % 4;
        
            if (dir == 0) { // east
                j++;
            } else if (dir == 1) { // south
                i++;
            } else if (dir == 2) { // west
                j--;
            } else if (dir == 3) { // north
                i--;
            }
            
            if (i < 0) {
                i++;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (i == arr.length) {
                i--;
                break;
            } else if (j == arr[0].length) {
                j--;
                break;
            }
        }
        System.out.println(i + "\n" + j);
    }
    
    public static void rotate90(){
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            int li = 0;
            int ri = arr[i].length - 1;
            while (li < ri) {
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;

                li++;
                ri--;
            }
        }
         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void diagonaltraversal(){
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int g = 0; g < arr.length; g++) {
            for (int i = 0, j = g; j < arr.length; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
    
    public static void searchInSorted(){
         int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();

        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (x == arr[i][j]) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if (x < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Not Found");
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows:");
        int n = sc.nextInt();
        System.out.print("Enter number of columns:");
        int m = sc.nextInt();
        
        int[][] arr = new int[n][m];
        
        System.out.print("Enter values:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Array :");
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}