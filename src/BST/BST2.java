package BST;

public class BST2<E extends Comparable<E>> {

    public class Node{

        public E e;

        public Node right;

        public Node left;

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this.e = null;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public int size;

    public BST2() {
        this.root = new Node();
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public boolean contains(E e){
        return contains(root , e);
    }

    private boolean contains(Node node , E e){
        if(node == null){
            return false;
        }
        else if(e.compareTo(node.e) < 0){
            return contains(node.left , e);
        }
        else if(e.compareTo(node.e) > 0){
            return contains(node.right , e);
        }else{
            return true;
        }
    }

    public void add(E e){
        root = add(root , e);
    }

    private Node add(Node node , E e){

        if(node == null){
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left ,e);
        }
        else if(e.compareTo(node.e) > 0){
            node.right = add(node.right , e);
        }else {
            node.e = e;
        }

        return node;
    }

    //遍历操作

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
        inOrder(node.left);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.left);
        System.out.println(node.e);
    }

    public E minimum(){
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E maximum(){
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    public E removeMax(){
        E ret = maximum(root).e;
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            //卡了(如果待删除待节点右边为空，但是左边有节点，需要把这个节点接上去)
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public E removeMin(){
        E ret = minimum(root).e;
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

    public void remove(E e){
        root = remove(root , e);
    }

    private Node remove(Node node , E e){
        if(node == null){
            return null;
        }//卡
        if(e.compareTo(node.e) < 0){
            //小 往左
            node.left = remove(node.left , e);
            return node;//卡 没写
        }
        if(e.compareTo(node.e) > 0){
            //大 往右
            node.right = remove(node.right ,e);
            return node;//卡 没写
        }else{
            // e的值相等
            if(node.left == null){
                //有右节点 把右节点接上去
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else{
                //这个待删除的节点既有左节点，也有右节点。
                Node suc = minimum(node.right);
                suc.left = node.left;
                node.right = removeMin(node.right);
                suc.right = node.right;
                size--;
                node.right = node.left = null;
                return suc;
            }
        }
    }
}
