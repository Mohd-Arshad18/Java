import java.util.*;
public class Main {
    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static class Pair{
        Node node;
        int state;
        
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null? "." :node.left.data + "";
        str += "<--" + node.data + "-->";
        str += node.right == null? "." :node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }  
    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;
        return ts;
    }
    
    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lm = max(node.left);
        int rm = max(node.right);
        int tm = Math.max(node.data, Math.max(lm, rm));
        
        return tm;
    }
    
    public static int height(Node node){
        if(node == null){
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        
        return th;
    }
    
    public static void traversal(Node node){
        if(node == null){
            return;
        }
        System.out.println("Pre order:" + node.data);
        traversal(node.left);
        System.out.println("In order:" + node.data);
        traversal(node.right);
        System.out.println("Post order:" + node.data);
    }
    
    public static void levelTraversal(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        
        while(mq.size() > 0){
            int count = mq.size();
            for(int i = 0; i < count; i++){
                node = mq.remove();
                System.out.print(node.data);
                
                if(node.left != null){
                    mq.add(node.left);
                }
                if(node.right != null){
                    mq.add(node.right);
                }
            }
            System.out.println();
        }
    }
    
    public static void traveralitretively(Node node){
        Stack<Pair> st = new Stack<>();
        Pair rtp = new Pair(node, 1);
        st.push(rtp);
        String pre = "";
        String in = "";
        String post = "";
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                pre += top.node.data + " ";
                top.state++;
                if(top.node.left != null){
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            }else if(top.state == 2){
                in += top.node.data + " ";
                top.state++;
                if(top.node.right != null){
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            }else{
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    
    static ArrayList<Integer> path;
    public static boolean findandpath(Node node, int num){
        if(node == null){
            return false;
        }
        if(node.data == num){
            path.add(node.data);
            return true;
        }
        if(findandpath(node.left, num)){
            path.add(node.data);
            return true;
        }
        if(findandpath(node.right, num)){
            path.add(node.data);
            return true;
        }
        System.out.println(path);
        return false;
    }
    
    public static void printkleveldown(Node node, int k){
        if(node == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.print(node.data);
        }
        printkleveldown(node.left, k-1);
        printkleveldown(node.right, k-1);
    }
    
    
    
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70 ,null, null, 87, null, null};
        
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        
        int idx = 0;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{
                st.pop();
            }
        }
        display(root);
        traversal(root);
    }
}    