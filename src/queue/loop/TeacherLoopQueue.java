package queue.loop;

import queue.ArrayQueue;
import queue.Queue;

import java.util.NoSuchElementException;
import java.util.Random;

public class TeacherLoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;  // 有兴趣的同学，在完成这一章后，可以思考一下：
    // LoopQueue中不声明size，如何完成所有的逻辑？
    // 这个问题可能会比大家想象的要难一点点：）

    public TeacherLoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public TeacherLoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front)
            resize(getCapacity()*2);
        data[tail]=e;
        tail=(tail+1)%(data.length);
        size++;
    }

    private void resize(int newCap) {
        E[] newD= (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            newD[i]=data[(i+front)%data.length];
        }
        data=newD;
        front=0;
        tail=size;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new NoSuchElementException("Empty queue");
        E value = data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4&&getCapacity()>2)
            resize(getCapacity()/2);
        return value;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public int getCapacity(){
        return data.length-1;
    }


    public static void main(String[] args){

        TeacherLoopQueue<Integer> queue = new TeacherLoopQueue<>();
//        for(int i = 0 ; i < 100000 ; i ++){
//            queue.enqueue(i);
//            System.out.println(queue);

//            if(i % 2 == 0){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
        System.out.println(testQ(queue,100000));
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>(100000);
        System.out.println(testQ(integerArrayQueue,100000));
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
