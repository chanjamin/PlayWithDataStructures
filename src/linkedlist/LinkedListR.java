package linkedlist;

/**
 * 递归的实现
 *
 * @param <E>
 */
public class LinkedListR<E> {

    private Node head;
    private int size;

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public LinkedListR() {
        head = null;
        size = 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        head = add(head, index, e);
        size++;
    }

    private Node add(Node node, int index, E e) {
        //既处理了头节点,又处理了递归条件
        if (index == 0)
            return new Node(e, node);
        //this节点下一个为递归返回的节点
        node.next = add(node.next, index - 1, e);
        return node;
    }

    private Node remove(Node node, int index) {
        if (1== index)
        {
            Node removed = node.next;
            node.next = node.next.next;
            return removed;
        }
        else{
            return  remove(node.next,--index);
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E removeLast() {
        return remove(size);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        size--;
        return remove(head,index).e;
    }

    public E getFirst() {
        return head.e;
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        set(head,index,e);
    }
    private void set(Node node,int index,E e){
        if(index==0)
            node.e=e;
        else
            set(node.next,--index,e);
    }

    public boolean contains(E e) {
        return contains(head,e);
    }

    private boolean contains(Node node, E e) {
        if(node==null)
            return false;
        if(node.e==e)
            return true;
        return contains(node.next,e);
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList ");
        builder.append("size=").append(getSize()).append("; {");
//        Node cur=head.next    z;
//        while (cur.next!=null){
//            builder.append(cur).append(",");
//        }
        for (Node cur = head; cur != null; cur = cur.next)
            builder.append(cur + "->");
        builder.append("null");
        return builder.append("}").toString();
    }
}