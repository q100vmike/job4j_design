package newcoll.tree;

import collection.SimpleQueue;
import java.util.ArrayList;
import java.util.List;

public class TreeUtils<T> {

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
            if (node.getChildren().size() > 0) {
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
            if (node.getChildren().size() > 0) {
                for (Node<T> child : node.getChildren()) {
                    queue.push(child);
                    roots.add(child.getValue());
                }
            }
        }
        return roots;
    }
}