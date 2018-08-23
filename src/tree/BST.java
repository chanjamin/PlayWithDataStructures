package tree;

import java.util.*;

public class BST<E extends Comparable<E>> {
    private Node root;

    public class Node<E> {
        private E e;
        private Node left;
        private Node right;
        private int size;
        private int depth;
        private int count;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e, Node left, Node right, int size, int depth, int count) {
            this.e = e;
            this.left = left;
            this.right = right;
            this.size = size;
            this.depth = depth;
            this.count = count;
        }
    }

    public int getSize() {
        return root.size;
    }

    public boolean isEmpty() {
        return root.size == 0;
    }

    public void add(E e) {
        root = add(root, e, 0);
    }

    private Node add(Node node, E e, int depth) {
        //没有此节点
        if (node == null) {
            return new Node(e, null, null, 1, depth, 1);
        }
        ++node.size;
        if (node.e.equals(e)) {
            ++node.count;
            return node;
        }
        if (e.compareTo((E) node.e) < 0)
            node.left = add(node.left, e, ++depth);
        else if (e.compareTo((E) node.e) > 0)
            node.right = add(node.right, e, ++depth);
        return node;
    }

    public boolean contains(E e) {
        Node node = contains(root, e);
        return node != null && node.e == e;
    }

    private Node contains(Node node, E e) {
        if (node == null)
            return null;
        else if (e.compareTo((E) node.e) == 0)
            return node;
        else if (e.compareTo((E) node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public E select(int index){
        if(index<0||index>root.size)
            return null;
        return (E) midTraverseToList(root).get(index).e;
    }
//    private Node select(Node node, int index, int fIndex) {
//        if (node == null)
//            return null;
//        select(node.left,++index,fIndex);
//        if(index==fIndex)
//            return node;
//        select(node.right,++index,fIndex);
//        return node;
//    }

    public void levelTraverse() {
        if (root == null)
            return;
        Queue<Node> nodes = new LinkedList<>();
        ((LinkedList<Node>) nodes).push(root);
        while (!nodes.isEmpty()) {
            Node first = ((LinkedList<Node>) nodes).remove();
            System.out.println(first.e);
            if (first.left != null)
                ((LinkedList<Node>) nodes).add(first.left);
            if (first.right != null)
                ((LinkedList<Node>) nodes).add(first.right);
        }
    }

    public void preTraverse() {
        preTraverse(root);
    }

    /**
     * 非递归先序遍历,栈
     */
    private void preTraverseNR() {
        if (root == null)
            return;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> cur = stack.pop();
            System.out.println(cur);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    private void preTraverse(Node node) {
        if (node == null)
            return;
        System.out.println(node.e + "\tcount:" + node.count + " depth:" + node.depth + " size:" + node.size);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void midTraverse() {
        midTraverse(root);
    }

    private void midTraverse(Node root) {
        if (root == null)
            return;
        midTraverse(root.left);
        System.out.println(root.e);
        midTraverse(root.right);
    }

    private List<Node> midTraverseToList(Node root) {
        List<Node> list = new ArrayList<>();
        if (root == null)
            return list;
        list.addAll(midTraverseToList(root.left));
        list.add(root);
        list.addAll(midTraverseToList(root.right));
        return list;
    }

    public void backTraverse() {
        backTraverse(root);
    }

    private void backTraverse(Node root) {
        if (root == null)
            return;
        midTraverse(root.left);
        midTraverse(root.right);
        System.out.println(root.e);
    }

    /**
     * @return 寻找二分搜索树的最小元素
     */
    public E minimum() {
        if (root.size == 0)
            throw new IllegalArgumentException("BST is empty");
        return (E) minimum(root).e;
    }


    private Node minimum(Node root) {
        return root.left == null ? root : minimum(root.left);
    }

    /**
     * @return 最大元素
     */
    public E maximum() {
        if (root.size == 0)
            throw new IllegalArgumentException("BST is empty");
        return (E) maximum(root).e;
    }

    private Node maximum(Node root) {
        if (root.right == null)
            return root;
        return maximum(root.right);
    }

    public E removeMin() {
        E minimum = minimum();
        root = removeMin(root);
        return minimum;
    }

    private Node removeMin(Node node) {
        node.size--;
        node.depth--;
        //如果左节点为空,此节点最小,返回右节点(无论是否为空)用于拼接
        if (node.left == null) {
            Node ret = node.right;
            node.right = null;
            if (ret != null)
                ret.count--;
            return ret;
        }
        //如果没有node.left=,变成空树
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E maximum = maximum();
        root = removeMax(root);
        return maximum;
    }

    private Node removeMax(Node node) {
        node.size--;
        node.depth--;
        if (node.right == null) {
            Node ret = node.left;
            node.left = null;
            if (ret != null)
                ret.count--;
            return ret;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return node;

        if (e.compareTo((E) node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            //左空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                node.size--;
                return rightNode;
            }
            //右空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                node.size--;
                return leftNode;
            }
            //都不为空
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            return successor;
        }
    }

    /**
     * 和e最接近的小于e的元素
     * if thisNode.e> e return leftNode.maxNode
     * else if eq return thisNode.e
     * else return null;
     * And explain in program way
     *
     * @param e
     * @return
     */
    public E floor(E e) {
        Node minNode = floor(root, e);
        return minNode == null ? null : (E) minNode.e;
    }

    /**
     * return left tree.right leaf which root 轻微小于 e
     *
     * @param node
     * @param e
     * @return
     */
    private Node floor(Node node, E e) {
        if (node == null)
            return null;
        int compare = e.compareTo((E) node.e);
        if (compare == 0)
            return node;
        else if (compare < 0)//当前节点>查找值
            return floor(node.left, e);
        else {
            Node rightMin = floor(node.right, e);
            if (rightMin == null)
                return node;
            else
                return rightMin;
        }
    }

    public E ceil(E e) {
        Node ceilNode = ceil(root, e);
        return ceilNode == null ? null : (E) ceilNode.e;
    }

    private Node ceil(Node node, E e) {
        if (node == null)
            return null;

        int cmp = e.compareTo((E) node.e);
        if (cmp == 0)
            return node;
        if (cmp > 0)
            return ceil(node.right, e);
        Node leftNode = ceil(node.left, e);
        if (leftNode != null)
            return leftNode;
        else
            return node;
    }
}
