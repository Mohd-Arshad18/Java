import java.util.*;
public class Main {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        
        Node(){
            
        }
        Node(int data){
            this.data = data;
        }
    }
    
    public static void display(Node node){
        String str = node.data + "-->";
        for(Node child: node.children){
            str += child.data + ", ";
        }
        str += ". ";
        System.out.println(str);
        for(Node child: node.children){
            display(child);
        }
    }
    
    public static int size(Node node){
        int s = 0;
        for(Node child: node.children){
            int cs = size(child);
            s = s + cs;
        }
        s = s + 1;
        
        return s;
    }
    
    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        
        for(Node child: node.children){
            int cm = max(child);
            max = Math.max(cm, max);
        }
        max = Math.max(node.data, max);
        
        return max;
    }
    
    public static int height(Node node){
        int h = -1;
        for(Node child: node.children){
            int ch = height(child);
            h = Math.max(ch, h);
        }
        h = h + 1;
        return h;
    }
    
    public static void traversal(Node node){
        System.out.println("Node pre:" + node.data);
        for(Node child: node.children){
            System.out.println("Edge pre:" + node.data + "--" + child.data);
            traversal(child);
            System.out.println("Edge post:" + node.data + "--" + child.data);
        }
        System.out.println("Node post:" + node.data);
    }
    
    public static void levelOrder(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0){
            node = q.remove();
            System.out.print(node.data + " ");
            
            for(Node child: node.children){
                q.add(child);
            }
        }
        System.out.println(".");
    }
    
    public static void levelOrderLinewise(Node node){
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        q.add(node);
        while(q.size() + cq.size() > 0){
            node = q.remove();
            System.out.print(node.data + " ");
            
            for(Node child: node.children){
                cq.add(child);
            }
            
            if(q.size() == 0){
                q = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    
    public static void levelOrderLinewiseZZ(Node node){
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.push(node);
        int level = 1;
        while(ms.size() > 0){
            node = ms.pop();
            System.out.print(node.data + " ");
            
            if(level%2 == 1){
                for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }else{
                for(int i = node.children.size() - 1; 0 >= i; i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
    
    public static void levelOrderLinewise2(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));
        
        while(q.size() > 0){
            node = q.remove();
            if(node.data != -1){
                System.out.print(node.data + " ");
                
                for(Node child: node.children){
                    q.add(child);
                }
            }else{
                if(q.size() > 0){
                    q.add(new Node(-1));
                    System.out.println();
                }    
            }
            
        }
        
    }
    
    public static void levelOrderLinewise3(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        
        while(q.size() > 0){
            int cicl = q.size();
            
            for(int i = 0; i < cicl; i++){
                node = q.remove();
                System.out.print(node.data + " ");
                
                for(Node child: node.children){
                    q.add(child);
                }
            System.out.println();
            }    
        }
    }
    
    public static void mirror(Node node){
        for(Node child: node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
    }
    
    public static void removeLeave(Node node){
        for(int i = node.children.size() - 1; i >= 0; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }
        for(Node child: node.children){
            removeLeave(child);
        }
    }
    
    public static void linearize(Node node){
        for(Node child: node.children){
            linearize(child);
        }
        while(node.children.size() > 1){
            Node lc = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slt = getTail(sl);
            slt.children.add(lc);
        }
    }
    
    public static Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }
    
    public static Node linearize2(Node node){
        if(node.children.size() == 0){
            return node;
        }
        Node lkt = linearize2(node.children.get(node.children.size() - 1));
        while(node.children.size() > 0){
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slt = linearize2(sl);
            slt.children.add(last);
        }
        return lkt;
    }
    
    public static boolean find(Node node, int data){
        if(node.data == data){
            return true;
        }
        for(Node child: node.children){
            boolean fic = find(child, data);
            if(fic){
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList<Integer> nodetorootpath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for(Node child: node.children){
            ArrayList<Integer> ptc = nodetorootpath(child, data);
            if(ptc.size() > 0){
                ptc.add(node.data);
                return ptc;
            }
            
        }
        return new ArrayList<>();
    }
    
    public static int lca(Node node, int d1, int d2){
        ArrayList<Integer> p1 = nodetorootpath(node, d1);
        ArrayList<Integer> p2 = nodetorootpath(node, d2);
        
        int i = p1.size() - 1;
        int j = p2.size() - 1;
        while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        
        return p1.get(i);
    }
    
    public static int distanceBetweenTwoNode(Node node, int d1, int d2){
        ArrayList<Integer> p1 = nodetorootpath(node, d1);
        ArrayList<Integer> p2 = nodetorootpath(node, d2);
        
        int i = p1.size() - 1;
        int j = p2.size() - 1;
        while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        
        return i + j;
    }
    
    public static boolean areSimilar(Node n1, Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i = 0; i < n1.children.size(); i++){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if(areSimilar(c1, c2) == false){
                return false;
            }
        }
        return true;
    }
    
    public static boolean areMirror(Node n1, Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i = 0; i < n1.children.size(); i++){
            int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if(areMirror(c1, c2) == false){
                return false;
            }
        }
        return true;
    }
    
    public static boolean IsSymmetric(Node node){
        return areMirror(node, node);
    }
    
    static int size;
    static int max;
    static int min;
    static int height;
    public static void multisolver(Node node, int depth){
        size++;
        max = Math.max(max, node.data);
        min = Math.min(min, node.data);
        height = Math.max(height, depth);
        for(Node child: node.children){
            multisolver(child, depth + 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = null;
        
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node temp = new Node();
                temp.data = arr[i];
                
                if(st.size() > 0){
                    st.peek().children.add(temp);
                }else{
                    root = temp;
                }
                st.push(temp);
            }
        }
        size = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        height = 0;
        
        display(root);
        System.out.println(size(root));
        System.out.println(max(root));
        System.out.println(height(root));
        traversal(root);
        levelOrder(root);
        levelOrderLinewise(root);
        levelOrderLinewiseZZ(root);
    }
}