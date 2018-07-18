package linkedlist;

public class Main {
    public static void main(String[] args) {
        MLinkedList<Integer> list = new MLinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(3);
        list.removeFirst();
//        list.removeLast();
        System.out.println(list);
    }
}
