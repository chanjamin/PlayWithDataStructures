package stack;

import linkedlist.TLinkedList;

public class LinkedListStack<E> implements Stack<E>{
    private TLinkedList<E> linkedList=new TLinkedList<>();

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.getSize()==0;
    }
}
