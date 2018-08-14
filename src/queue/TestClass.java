package queue;

//import org.junit.Test;
import queue.loop.TeacherLoopQueue;

public class TestClass {

//    @Test
    public void testLinkedListStack(){
        Queue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 20 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }

//    @Test
    public void testArrayQueue(){
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

//    @Test
    public void testPerformance(){

        TeacherLoopQueue<Integer> queue = new TeacherLoopQueue<>();
        System.out.println(testQ(queue,10000));
//        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>(100000);
//        System.out.println(testQ(integerArrayQueue,100000));
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        System.out.println(testQ(linkedListQueue,10000));
    }

    private static double testQ(Queue queue,int count){
        long time = System.nanoTime();
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        return  (System.nanoTime()-time)/1000000000.0;
    }
}
