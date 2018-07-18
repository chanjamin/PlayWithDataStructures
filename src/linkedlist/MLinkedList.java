package linkedlist;

/**
 * 单向链表,Node用next指向下一节点
 * 记录head,没有size
 * @param <E> 泛型
 */
public class MLinkedList<E> {

    private String string="";
    private Node head;

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

//    private int size;

    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next=head;
//        head=node;
        head=new Node(e,head);
        //
        string=e+string;
//        size++;
    }
    public void addLast(E e){
        Node lastNode=getLast();
        lastNode.next=new Node(e);
        //
        string+=e;
//        size++;
    }
    public Node removeFirst(){
        Node temp=head;
        head=head.next;
        //
//        size--;
        string=string.substring(head.toString().length());
        return temp;
    }
    public Node removeLast(){
        Node v = getLast();
        Node temp=v;
        string=string.substring(0,string.length()-v.toString().length());
        v=null;
//        size--;
        return temp;
    }

    private Node getLast() {
       return getLast(head);
    }

    private Node getLast(Node head) {
        if(head.next==null)
            return head;
        return  getLast(head.next);
    }



    public MLinkedList() {
        head=null;
//        size=0;
    }

    @Override
    public String toString() {
        return "MLinkedList : {"+string+"}";
    }
}
