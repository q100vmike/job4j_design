package collection;

import java.util.Objects;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    private int counter;

    public T poll() {
        counter--;
        return input.pop();
    }

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