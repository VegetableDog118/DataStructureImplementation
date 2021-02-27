package BST;
import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable> {

    private class Node{

        public E e;

        public Node left;

        public Node right;

        public Node(E e) {
            this.e = e;
            this.right = null;
            this.left = null;
        }
    }

    private Node root;

    private int size;

    public BST() {
        this.size = 0;
        this.root = null;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }

    private Node add(Node node,E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);

        } else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);

        }

        return node;
    }

   public boolean contains(E e){
        return contains(root,e);
   }

   private boolean contains(Node node,E e){
        if(node == null){
            return false;

        } else if(e.compareTo(node.e) < 0){
           return contains(node.left,e);

       } else if(e.compareTo(node.e) > 0){
           return contains(node.right,e);

       } else{
           return true;

       }
   }

   public void preOrder(){
        preOrder(root);
   }

   private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.e);

        preOrder(node.left);

        preOrder(node.right);

   }


    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);

        System.out.println(node.e);

        inOrder(node.right);

    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);

        postOrder(node.right);

        System.out.println(node.e);

    }

    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node node){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                queue.add(cur.left);
            }

            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("empty tree");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;

        }

        node.left = removeMin(node.left);
        return node;
    }

    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null)
            return node;

        return maximum(node.right);
    }

    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);

        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node,E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node suc = minimum(node.right);
            suc.left = node.left;
            suc.right = removeMin(node.right);
            node.right = node.left = null;

            return suc;
        }
    }
}
