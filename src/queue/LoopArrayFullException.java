package queue;

public class LoopArrayFullException extends RuntimeException {
    @Override
    public String getMessage() {
        return "循环队列已满\n"+super.getMessage();
    }
}
