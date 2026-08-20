import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<T> {
    private final Deque<T> deque = new ArrayDeque<>();

    public void push(T element) {
        deque.addFirst(element);
    }

    public T pop() {
        return deque.removeFirst();
    }

    public T peek() {
        return deque.peekFirst();
    }

    public int size() {
        return deque.size();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
