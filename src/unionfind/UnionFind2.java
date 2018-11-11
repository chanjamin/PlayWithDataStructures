package unionfind;

public class UnionFind2 implements UF {
    private int[] parent;

    public UnionFind2(int size) {
        parent=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
        }
    }

    private int findRoot(int p){
        while (parent[p]!=p)
            p=parent[p];
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
        int rootQ=findRoot(q);
        return rootP==rootQ;
    }

    @Override
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ=findRoot(q);
        if(rootP!=rootQ)
            parent[p]=q;
    }
}
