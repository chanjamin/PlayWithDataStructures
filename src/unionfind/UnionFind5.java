package unionfind;

public class UnionFind5 implements UF {
    private int[] parent;
    private int[] rank;//rank[i]表示以i为根的集合所表示的树的层数,不维护，1，大概准确，2，性能

    public UnionFind5(int size) {
        parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            this.rank[i] = 1;
        }
    }

    private int findRoot(int p) {
        while (parent[p] != p)
        {
            parent[p]=parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //根节点自己指向自己，否则不是根
    @Override
    public boolean isConnected(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        return rootP == rootQ;
    }

    //比较平均的Oh
    @Override
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if (rootP != rootQ) {
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
                //为什么不维护rank?因为小合并大，深度没变
//                rank[rootQ]+=rank[rootP];
            } else if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
//                size[rootP]+=rootQ;
            } else //  ==
            {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }
}
