package queue;

import linkedlist.TLinkedList;

public class LinkedListQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        private E e;
        private Node next;

        private Node(E e, Node next) {
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
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head==null&&tail==null;
    }

    @Override
    public void enqueue(E e) {
        if(isEmpty()){
            head=tail=new Node(e);
        }
        else {
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        Node cur = this.head;
        head=head.next;
        size--;
        return cur.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Queue:front {");
        Node cur = this.head;
        while (cur.next!=null){
            builder.append("->"+cur);
            cur=cur.next;
        }
        builder.append("} tail");
        return builder.toString();
    }
}
