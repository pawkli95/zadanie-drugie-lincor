import java.util.*;

public class StackWithoutExtraSpace
{
    private final Deque<Integer> stack = new ArrayDeque<>();

    private int minElement;

    public void push(int element)
    {
        if (stack.isEmpty())
        {
            stack.push(element);
            minElement = element;
        }
        else if (element > minElement) {
            stack.push(element);
        }
        else {
            stack.push(2 * element - minElement);
            minElement = element;
        }
    }

    public int pop() throws EmptyStackException
    {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!!!");
            throw new EmptyStackException();
        }

        int topElement = stack.peek();
        if (topElement < minElement) {
            int popElement = minElement;
            minElement = 2 * minElement - topElement;
            stack.pop();
            return popElement;
        } else {
            return stack.pop();
        }
    }

    public int peekMin() {
        return minElement;
    }
}
