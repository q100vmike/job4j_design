package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    private void expland() {
        container = Arrays.copyOf(container, container.length * 2);
    }
    @Override
    public void add(T value) {
        if (container.length == size) {
            expland();
        }
        container[size] = value;
        size++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, container.length);
        container[index] = newValue;
        return newValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, container.length);
        T[] temp = container.clone();
        if (index > 0) {
            System.arraycopy(container, 0, temp, 0, index - 1);
            System.arraycopy(container, index, temp, index, temp.length);
        } else {
            System.arraycopy(container, 0, temp, 1, index - 1);
        }

        return null;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return container.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {

                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return null;
            }
        };
    }
}
