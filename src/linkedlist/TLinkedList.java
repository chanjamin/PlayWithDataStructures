package linkedlist;

/**
 * 波波的实现
 * @param <E>
 */
public class TLinkedList<E>{

    private Node head;
    private int size;

    private class Node{
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public TLinkedList() {
        head=null;
        size=0;
    }

    public void addFirst(E e){
        head=new Node(e,head);
    }

    public void add(int index,E e){
        if(index<0||index>size)
            throw new IllegalArgumentException("索引异常");
        if(index==0)
            addFirst(e);
        else {
            Node prev=head;
            for (int i = 0; i <index-1; i++) {
                prev=prev.next;
            }
            prev.next=new Node(e,prev.next);
        }
    }

    public void addLast(E e) {
        add(size,e);
    }
}
