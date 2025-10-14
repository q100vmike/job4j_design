package newcoll.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node<E> {
    private E value;
    private List<Node<E>> children = (List<Node<E>>) new ArrayList<E>();

    public Node(E value) {
        this.value = value;
    }

    @SafeVarargs
    public Node(E value, Node<E>... children) {
        this.value = value;
        this.children.addAll(Arrays.asList(children));
    }

    @Override
    public String toString() {
        return String.format("Node{ %s }", value);
    }

    /* геттеры и сеттеры*/
}