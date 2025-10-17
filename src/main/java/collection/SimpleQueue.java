package collection;

import java.util.NoSuchElementException;
import java.util.Objects;
import newcoll.tree.Queue;

public class SimpleQueue<T> implements Queue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    private int counter;

    public int getCounter() {
        return counter;
    }

    @Override
    public T poll() {
        if (counter == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        counter--;
        return input.pop();
    }

    @Override
    public int size() {
        return getCounter();
    }
    @Override
    public void push(T value) {
        counter++;
        if (counter == 1) {
            input.push(value);
        } else {
            for (int i = 1; i < counter; i++) {
                output.push(input.pop());
            }
            output.push(value);
            for (int i = 0; i < counter; i++) {
                input.push(output.pop());
            }
        }
    }
}