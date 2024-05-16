package tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Node<E> findParent = findBy(parent).orElse(null);
        if (Objects.nonNull(findParent) && findBy(child).isEmpty()) {
            findParent.children.add(new Node(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> condition = n -> n.value.equals(value);
        Optional<Node<E>> node = findByPredicate(condition);
        return node;
    }
    public boolean isBinary() {
        Predicate<Node<E>> condition = n -> n.children.size() > 2;
        Optional<Node<E>> node = findByPredicate(condition);
        return node.isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (condition.test(element)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }
        return result;
    }
}
