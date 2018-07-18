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
        head=new Node(null,null);
        size=0;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){
        if(index<0||index>size)
            throw new IllegalArgumentException("索引异常");
            Node prev=head;
            for (int i = 0; i <index; i++) {
                prev=prev.next;
            }
            prev.next=new Node(e,prev.next);
    }

    public void addLast(E e) {
        add(size,e);
    }
    
    public void set(int index,E e){
        if(index<0||index>size)
            throw new IllegalArgumentException("索引异常");
        Node cur=head.next;
        for (int i = 0; i < index; i++) {
            cur.e=e;
        }
    }

    public boolean contains(E e ){
        Node cur=head.next;
        while (cur.next!=null){
            if(cur.e.equals(e)){
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList ");
        builder.append("size=").append(getSize()).append("; {");
//        Node cur=head.next;
//        while (cur.next!=null){
//            builder.append(cur).append(",");
//        }
        for (Node cur=head.next;cur!=null;cur=cur.next)
            builder.append(cur+"->");
        builder.append("null");
     return    builder.append("}").toString();
    }
}