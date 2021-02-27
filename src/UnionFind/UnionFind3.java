package UnionFind;
//基于union的操作让节点小的树指向节点多的树
public class UnionFind3 implements UF{

    private int[] parent;

    private int[] rank;//sz[i]表示以i为根的集合中的元素的个数

    public UnionFind3(int size) {
        parent = new int[size];
        for(int i = 0 ; i < size ; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p){

        if(p < 0 && p >= parent.length){
            throw new IllegalArgumentException("p is out of bound");
        }

        while (parent[p] != p){
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) {
            return;
        }

        if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}