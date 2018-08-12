package linkedlist;

public class BothWayLinkedList<E> {
    private Node dumbHead=new Node(-1,null,null);
    private Node tail;
    private int size;

    private class Node<E> {
        private E element;
        private Node prev, next;

        private Node(E element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("索引异常");
        Node prev = dumbHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e, prev, prev.next);
        tail=node;
        prev.next = node;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        if (index <= size / 2) {
            Node prev = dumbHead;
            for (int i = 0; i < index; i++) {
                //prev是要移除节点前节点
                prev = prev.next;
            }
            Node cur = prev.next;
            prev.next = prev.next.next;
            size--;
            return (E) cur.element;
        } else {
            Node prev = this.tail;
            for (int i = size; i >index ; i--) {
                prev=prev.prev;
            }
            Node cur = prev.next;
            prev.next = prev.next.next;
            size--;
            return (E) cur.element;
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList ");
        builder.append("size=").append(size).append("; {");
//        Node cur=head.next;
//        while (cur.next!=null){
//            builder.append(cur).append(",");
//        }
        for (Node cur=dumbHead.next;cur!=null;cur=cur.next)
            builder.append(cur.element+"->");
        builder.append("null");
        return    builder.append("}").toString();
    }
}
