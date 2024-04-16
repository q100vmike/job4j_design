package collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleLinked<E> {

    private int size = 0;
    private int modCount;
    private Node<E> head;

    public SimpleLinkedList() {
        head = new Node<>(null, null);
    }

    @Override
    public void add(E value) {
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

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = head;

        while (index != 0) {
            node = node.next;
            index--;
        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
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
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> curr = node;
                node = node.next;
                return curr.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
