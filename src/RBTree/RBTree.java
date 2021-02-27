package RBTree;


import Map.Map;

public class RBTree<K extends Comparable<K>,V> implements Map<K,V> {

    private static final boolean red = true;

    private static final boolean black = false;

    private class Node{

        public K key;

        public V value;

        public Node left;

        public Node right;

        public boolean color;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            color = red;
        }
    }

    private Node root;

    private int size;

    public RBTree() {
        this.root = null;
        this.size = 0;
    }

    private boolean isRed(Node node){
        if(node == null){
            return black;
        }
        return node.color;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){
        Node x = node.right;
        Node T2 = x.left;
        node.right = T2;
        x.left = node;

        x.color = node.color;
        node.color = red;
        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x = node.left;
        Node T1 = x.right;
        node.left = T1;
        x.right = node;

        x.color = red;
        x.left.color = black;
        x.right.color = black;
        return x;
    }

    private void flipColor(Node node){
        node.color = red;
        node.left.color = black;
        node.right.color = black;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = black;

    }

    private Node add(Node node, K key, V value){
        if(node == null){
            size++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key,value);
        }
        else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key,value);
        }else{
            node.value = value;
        }

        if(isRed(node.right) && ! isRed(node.left)){
            node = leftRotate(node);
        }

        if(isRed(node.left) && isRed(node.left.left)){
           node = rightRotate(node);
        }

        if(isRed(node.left) && isRed(node.right)){
           flipColor(node);
        }

        return node;
    }

    private Node getNode(Node node , K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) == 0){
            return node;

        } else if (key.compareTo(node.key) < 0){
            return getNode(node.left,key);

        } else{
            return getNode(node.right,key);

        }
    }

    public Node minimum(Node node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    public Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node , K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left , key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right , key);
            return node;
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else{
                Node suc = minimum(node.right);
                suc.left = node.left;
                suc.right = removeMin(node.right);
                return suc;
            }
        }
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root,key);
        return node != null;
    }

    @Override
    public V get(K key) {
        return getNode(root,key).value;
    }

    @Override
    public void set(K key, V value) {
        getNode(root,key).value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}