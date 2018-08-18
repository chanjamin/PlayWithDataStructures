package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
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

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        //处理头节点
        if (node == null) {
            size++;
            return new Node(e, null, null);
        }
        if (e.compareTo((E) node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo((E) node.e) > 0)
            node.right = add(node.right,e);
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        else if (e.compareTo((E) node.e) == 0)
            return true;
        else if (e.compareTo((E) node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public void levelTraverse(){
        if(root==null)
            return;
        Queue<Node> nodes = new LinkedList<>();
        ((LinkedList<Node>) nodes).push(root);
        while (!nodes.isEmpty()){
            Node first = ((LinkedList<Node>) nodes).remove();
            System.out.println(first.e);
            if(first.left!=null)
                ((LinkedList<Node>) nodes).add(first.left);
            if(first.right!=null)
                ((LinkedList<Node>) nodes).add(first.right);
        }
    }

    public void preTraverse(){
        preTraverse(root);
    }

    /**
     * 非递归先序遍历,栈
     */
    private void preTraverseNR(){
        if (root==null)
            return;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node<E> cur = stack.pop();
            System.out.println(cur);
            if(cur.right!=null)
                stack.push(cur.right);
            if (cur.left!=null)
                stack.push(cur.left);
        }
    }
    private void preTraverse(Node root) {
        if(root==null)
            return;
        System.out.println(root.e);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public void midTraverse(){
        midTraverse(root);
    }

    private void midTraverse(Node root) {
        if(root==null)
            return;
        midTraverse(root.left);
        System.out.println(root.e);
        midTraverse(root.right);
    }

    public void backTraverse(){
        backTraverse(root);
    }

    private void backTraverse(Node root) {
        if(root==null)
            return;
        midTraverse(root.left);
        midTraverse(root.right);
        System.out.println(root.e);
    }

    /**
     * @return 寻找二分搜索树的最小元素
     */
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return (E) minimum(root).e;
    }


    private Node minimum(Node root) {
        return root.left==null?root: minimum(root.left);
    }

    /**
     *
     * @return 最大元素
     */
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return (E) maximum(root).e;
    }

    private Node maximum(Node root) {
        if(root.right==null)
            return root;
        return maximum(root.right);
    }

    public E removeMin(){
        E minimum = minimum();
        root=removeMin(root);
        return minimum;
    }

    private Node removeMin(Node node) {
        //如果左节点为空,此节点最小,返回右节点(无论是否为空)用于拼接
        if(node.left==null){
            Node ret = node.right;
            node.right=null;
            size--;
            return ret;
        }
        //如果没有node.left=,变成空树
        node.left= removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E maximum = maximum();
        root=removeMax(root);
        return maximum;
    }

    private Node removeMax(Node node) {
        if(node.right==null){
            Node ret = node.left;
            node.left=null;
            size--;
            return ret;
        }
        node.right=removeMax(node.right);
        return node;
    }
}
