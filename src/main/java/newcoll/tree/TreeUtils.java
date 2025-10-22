package newcoll.tree;

import collection.SimpleQueue;
import collection.SimpleStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TreeUtils<T> {

    private Optional<Node<T>> currParent = Optional.empty();

    public int countNode(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        Node<T> node;
        Queue<Node<T>> queue = new SimpleQueue<>();
        queue.push(root);

        while (queue.size() > 0) {
            node = queue.poll();
            count++;
            if (!node.getChildren().isEmpty()) {
                for (Node<T> child : node.getChildren()) {
                    queue.push(child);
                }
            }
        }
        return count;
    }

    public Iterable<T> findAll(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        List<T> roots = new ArrayList<>();
        Node<T> node;
        Queue<Node<T>> queue = new SimpleQueue<>();
        queue.push(root);
        roots.add(root.getValue());

        while (queue.size() > 0) {
            node = queue.poll();
            if (!node.getChildren().isEmpty()) {
                for (Node<T> child : node.getChildren()) {
                    queue.push(child);
                    roots.add(child.getValue());
                }
            }
        }
        return roots;
    }

    public boolean add(Node<T> root, T parent, T child) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        boolean result = false;
        stack.push(root);
        Optional<Node<T>> find = findByKey(root, parent);
        if (find.isPresent()) {
            result = true;
            find.get().getChildren().add(new Node<>(child));
        }

        return result;
    }

    public Optional<Node<T>> findByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        SimpleStack<Node<T>> roots = new SimpleStack<>();
        Optional<Node<T>> result = Optional.empty();
        stack.push(root);
        roots.push(root);

        while (stack.size() > 0) {
            Node<T> node = stack.pop();
            if (node.getValue() == key) {
                result = Optional.of(node);
                break;
            } else {
                if (!node.getChildren().isEmpty()) {
                    roots.push(node);
                    for (Node<T> child : node.getChildren()) {
                        stack.push(child);
                    }
                } else {
                    currParent = Optional.of(roots.pop());
                }
            }
        }

        return result;
    }

    public Optional<Node<T>> divideByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        Node<T> result = null;

        Optional<Node<T>> found = findByKey(root, key);

        if (found.isPresent()) {
            found.get();
            result = new Node<>(found.get().getValue());
            result.setChildren(found.get().getChildren());
            if (currParent.isPresent()) {
                currParent.get().getChildren().remove(found.get());
            }
        }

        return Optional.of(result);
    }
}