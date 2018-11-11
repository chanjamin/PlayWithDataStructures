package unionfind;

public class UnionFind2 implements UF {
    private int[] parent;

    public UnionFind2(int size) {
        parent=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //根节点自己指向自己，否则不是根
    @Override
    public boolean isConnected(int p, int q) {
        while (parent[p]!=p)
            p=parent[p];
        while (parent[q]!=q)
            q=parent[q];
        return q==p;
    }

    @Override
    public void union(int p, int q) {
        while (parent[p]!=p)
            p=parent[p];
        while (parent[q]!=q)
            q=parent[q];
        if(p!=q)
            parent[p]=q;
    }
}
