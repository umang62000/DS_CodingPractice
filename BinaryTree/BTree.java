/*
  Construct
  using preorder-nlr
  maintain stack with value and state
  state=>1-left push,2-right push 3-pop

  steps
  1.Read value
  2.Push element with state 1
  3.Increase state of previous element
 */
import java.util.*;

public class BTree {

    public static class Node {
        Node left;
        Node right;
        int data;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(int state, Node node) {
            this.state = state;
            this.node = node;
        }
    }

    public static Node Treeconstruct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(1, root);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(1, top.node.left);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(1, top.node.right);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }

        }
        return root;
    }

    public static void display(Node node) {
        String str = "";
        if (node == null) {
            return;
        }
        str += node.left == null ? "." : node.left.data + "";
        str += "<- " + node.data + " ->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void traversalPre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        traversalPre(node.left);
        traversalPre(node.right);
    }

    public static void traversalPost(Node node) {
        if (node == null) {
            return;
        }
        traversalPost(node.left);
        traversalPost(node.right);
        System.out.print(node.data + " ");
    }

    public static void traversalIN(Node node) {
        if (node == null) {
            return;
        }
        traversalIN(node.left);
        System.out.print(node.data + " ");
        traversalIN(node.right);
    }

    static ArrayList<Integer> path;

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            path.add(node.data);
            return true;
        }
        boolean filc = find(node.left, data);
        if (filc) {
            path.add(node.data);
            return true;
        }
        boolean firc = find(node.right, data);
        if (firc) {
            path.add(node.data);
            return true;
        }
        return false;
    }

    public static void printsinglechild(Node node, Node parent) {
        if (node == null) {
            return;
        }
        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        }else if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }
        printsinglechild(node.left, node);
        printsinglechild(node.right, node);
    }

    public static void LevelOrder(Node node){
        Queue<Node> mq=new ArrayDeque<>();
        mq.add(node);
        while(mq.size()>0){
            int count =mq.size();
            for(int i=0;i<count;i++){
                node=mq.remove();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    mq.add(node.left);
                }   
                if(node.right!=null){
                    mq.add(node.right);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = Treeconstruct(arr);
        // Node root1=new Node(arr[0], null, null);
         display(root);
        // System.out.println();
        // display(root1);
        // traversalPre(root);
        // path = new ArrayList<>();
        // boolean findnode = find(root, 70);
        // System.out.println(findnode);
        // System.out.println(path);
        // printsinglechild(root, null);
        LevelOrder(root);

    }
}