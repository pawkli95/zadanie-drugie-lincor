import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

public class GenericStackWithExtraSpace<T extends Comparable<T>> {

    private final Deque<T> mainStack = new ArrayDeque<>();

    private final Deque<T> minStack = new ArrayDeque<>();

    public void push(T element) {
        mainStack.push(element);
        if (minStack.isEmpty() || element.compareTo(minStack.peek()) < 0) {
            minStack.push(element);
        }
    }


    public T pop() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }

        if (mainStack.peek().compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }

        return mainStack.pop();
    }

    public T peekMin() {
        if(minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }


}
