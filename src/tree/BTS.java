package tree;

public class BTS<E extends Comparable<E>> {
    private int size;
    private Node root;

    public class Node<E> {
        private E e;
        private Node left;
        private Node right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e) {
        add(root,e);
        size++;
    }

    private Node add(Node node, E e) {
        //处理头节点
        if(node==null)
            return new Node(e,null,null);
        if(e.compareTo((E) node.e)<0)
            node.left=new Node(e,null,null);
        else if(e.compareTo((E)node.e)>0)
            node.right=new Node(e,null,null);
        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if(node==null)
            return false;
        else if(e.compareTo((E)node.e)==0)
            return true;
        else if(e.compareTo((E) node.e)<0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }
}
