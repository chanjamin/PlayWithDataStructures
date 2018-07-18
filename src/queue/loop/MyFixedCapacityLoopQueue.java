package queue.loop;

import queue.LoopArrayFullException;
import queue.Queue;

public class MyFixedCapacityLoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;
    private int capacity;

    public MyFixedCapacityLoopQueue(int capacity) {
        this.data= (E[]) new Object[capacity];
        this.front=0;
        this.tail=0;
        this.size=0;
        this.capacity=capacity;
    }

    public MyFixedCapacityLoopQueue() {
        this.data= (E[]) new Object[10];
        this.front=0;
        this.tail=0;
        this.size=0;
        this.capacity=10;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail&&size==0;
    }

    @Override
    public void enqueue(E e) {
        //是否数组满,抛出异常
        if(tail+1==front)
            throw new LoopArrayFullException();

        //tail是数组尾部
        if (tail+1==capacity) {
            //数组头没有空余1以上,
            if(front<2)
                throw new LoopArrayFullException();
            else {
                data[tail]=e;
                tail=0;
                ++size;
            }
        }
        //tail不是数组尾部
        else{
            data[tail]=e;
            tail++;
            ++size;
        }
    }

    @Override
    public E dequeue() {
        size--;
        E temp = data[front];
        data[front++]=null;
        return temp;
    }

    @Override
    public E getFront() {
        return data[front];
    }
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, capacity));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }

        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args){

        MyFixedCapacityLoopQueue<Integer> queue = new MyFixedCapacityLoopQueue<>(10);
        for(int i = 0 ; i < 12 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
