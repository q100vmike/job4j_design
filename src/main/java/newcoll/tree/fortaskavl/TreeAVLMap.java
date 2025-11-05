package newcoll.tree.fortaskavl;

import collection.binarytree.avl.AvlTree;

import java.util.*;

public class TreeAVLMap<T extends Comparable<T>, V> {

    private Node root;

    public boolean put(T key, V value) {

        boolean result = false;
        Node node  = new Node(key, value);

        if (Objects.nonNull(value) && !contains(key)) {
            root = put(root, node);
            result = true;
        }
        return result;
    }

    public Node put(Node parent, Node child) {

        if (Objects.nonNull(parent)) {
            int comparisonResult = parent.key.compareTo(child.key);
            if (comparisonResult < 0) {
                parent.left = put(parent.left, child);
            } else {
                parent.right = put(parent.right, child);
            }
            updateHeight(node);
            result = balance(node);
        }
        return result;
    }

    public boolean contains(T key) {
        boolean result = contains(root, key);
        return result;
    }

    private boolean contains(Node node, T key) {
        boolean result = false;
        if (!node.key.equals(key)) {
            if (key.compareTo(node.key) < 0) {
                if (!Objects.isNull(node.left)) {
                    result = contains(node.left, key);
                }
            } else {
                if (!Objects.isNull(node.right)) {
                    result = contains(node.right, key);
                }
            }
        } else {
            result = true;
        }
        return result;
    }

    public boolean remove(T key) {
        // TODO реализуйте метод
        return false;
    }

    public V get(T key) {
        // TODO реализуйте метод
        return null;
    }

    public Set<T> keySet() {
        // TODO реализуйте метод
        return null;
    }

    public Collection<V> values() {
        // TODO реализуйте метод
        return null;
    }

    private class Node {
        private int balanceFactor;
        private T key;
        private V value;
        private int height;
        private Node left;
        private Node right;

        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public int getBalanceFactor() {
            return balanceFactor;
        }

        public void setBalanceFactor(int balanceFactor) {
            this.balanceFactor = balanceFactor;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}