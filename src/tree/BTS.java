package tree;

public class BTS<E extends Comparable<E>> {
    private int size;
    private Node root;

    private class Node<E> {
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
        if (root == null)
            this.root = new Node(e, null, null);
        else add(root, e);
        size++;
    }

    private void add(Node node, E e) {
        if (e.equals(node.e))
            return;
        else if (e.compareTo((E) node.e) < 0 && node.left == null) {
            node.left = new Node(e, null, null);
            return;
        } else if (e.compareTo((E) node.e) > 0 && node.right == null) {
            node.right = new Node(e, null, null);
            return;
        } else if(e.compareTo((E) node.e)<0)
                add(node.left,e);
        else
            add(node.right,e);
    }
}
