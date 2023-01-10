import java.util.EmptyStackException;

public class MyStack<T> {

    private T value;
    private static final int INITIAL_CAPACITY = 10;
    private int capacity;
    private int size;
    private Node<T> previous;
    private Node<T> top; // peak

    public MyStack() {
        this.capacity = INITIAL_CAPACITY;
    }
    public MyStack(int capacity){
        this();
        if(capacity > 0){
            this.capacity = capacity;
        }
    }

    public T push(T value){
        if(isFull()){
            throw new StackOverflowError("stack can't hold more than " + capacity+ " elements");
        }
        Node<T> node = new Node<>(value);
        if(!isEmpty()){
            node.previous = top;
        }
        top = node;
        size++;
        return node.value;
    }

    public T pop(){
        if(isEmpty()){
            throw  new EmptyStackException();
        }
        Node<T> node = top;
        top = node.previous;
        size--;
        return node.value;
    }
    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public T peek(){
        if(!isEmpty()){
            return top.value;
        }
        return null;
    }

    public int size(){
        return size;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        if(!isEmpty()){
            sb.append("Top");
            while (current.previous != null){
                sb.append(current).append(" -> ");
                current = current.previous;
            }
            sb.append(current);
        }
        return sb.toString();
    }

    static class Node<T>{
        private final T value;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
                    return "[" + value + "]";
        }
    }
}
