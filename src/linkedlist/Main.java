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

        TLinkedList<Integer> linkedList = new TLinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
        System.out.println(linkedList.remove(3));
        System.out.println(linkedList);
    }
}
