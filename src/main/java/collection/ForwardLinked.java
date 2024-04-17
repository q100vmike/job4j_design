package collection;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public ForwardLinked() {
        head = new Node<>(null, null);
    }

    public void add(T value) {
        Node node;
        if (Objects.isNull(head.item)) {
            head.item = value;
        } else {
            node = head;
            while (Objects.nonNull(node.next)) {
                node = node.next;
            }
            node.next = new Node<>(value, null);
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> node = head;

        while (index != 0) {
            node = node.next;
            index--;
        }
        return node.item;
    }

    public T deleteFirst() {
        if (Objects.isNull(head.item)) {
            throw new NoSuchElementException();
        }
        T headItem = head.item;
        Node<T> node = head;
        head = node.next;
        node.item = null;
        node.next = null;
        return headItem;
    }
    public void addFirst(T value) {
        Node first = new Node<>(value, head);
        head = first;
        size++;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node node = head;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return Objects.nonNull(node) && size > 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> curr = node;
                node = node.next;
                return curr.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}