package newcoll.tree.fortaskavl;

import collection.binarytree.VisualNode;

import java.util.*;

public class TreeAVLMap<T extends Comparable<T>, V> {

    private Node root;

    public boolean put(T key, V value) {
        boolean result = false;
        if (key == null) {
            return false;
        }
        if (Objects.nonNull(root)) {
            if (!contains(key)) {
                root = put(root, key, value);
                result = true;
            } else {
                get(root, key).setValue(value);
                result = true;
            }
        } else {
            root = new Node(key, value);
            result = true;
        }
        return result;
    }

    public Node put(Node parent, T key, V value) {
        Node node  = new Node(key, value);

        if (Objects.nonNull(parent)) {
            int comparisonResult = node.key.compareTo(parent.key);
            if (comparisonResult < 0) {
                parent.left = put(parent.left, key, value);
            } else {
                parent.right = put(parent.right, key, value);
            }
            updateHeight(parent);
            node = balance(parent);
        }
        return node;
    }

    private void updateHeight(Node node) {
        int leftNodeHeight = Objects.isNull(node.left) ? -1 : node.left.height;
        int rightNodeHeight = Objects.isNull(node.right) ? -1 : node.right.height;
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node node) {
        Node result = node;
        if (node.balanceFactor < -1) {
            if (node.left.balanceFactor >= 0) {
                result = leftRightCase(node);
            } else {
                result = rightRotation(node);
            }
        } else if (node.balanceFactor > 1) {
            if (node.right.balanceFactor >= 0) {
                result = leftRotation(node);
            } else {
                result = rightLeftCase(node);
            }
        }
        return result;
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private Node leftRotation(Node node) {

        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        updateHeight(node);
        updateHeight(newParent);

        return newParent;
    }

    private Node rightRotation(Node node) {

        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        updateHeight(node);
        updateHeight(newParent);

        return newParent;
    }

    public boolean contains(T key) {
        boolean result = false;
        if (Objects.nonNull(root)) {
            result = contains(root, key);
        }
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
        boolean result = false;
        if (Objects.nonNull(key) && Objects.nonNull(root) && contains(key)) {
            root = remove(root, key);
            result = true;
        }
        return result;
    }

    private Node remove(Node node, T element) {
        if (node == null) {
            return null;
        }
        int comparisonResult = element.compareTo(node.key);
        if (comparisonResult < 0) {
            node.left = remove(node.left, element);
        } else if (comparisonResult > 0) {
            node.right = remove(node.right, element);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if (node.left.height > node.right.height) {
                    T heir = maximum(node.left).key;
                    node.key = heir;
                    node.left = remove(node.left, heir);
                } else {
                    T heir = minimum(node.right).key;
                    node.key = heir;
                    node.right = remove(node.right, heir);
                }
            }
        }
        updateHeight(node);
        return balance(node);
    }

    public T minimum() {
        return Objects.nonNull(root) ? minimum(root).key : null;
    }

    private Node minimum(Node node) {
        Node min = null;

        if (!Objects.isNull(node.getLeft())) {
            min = minimum(node.left);
        } else {
            min = node;
        }
        return min;
    }

    public T maximum() {
        return Objects.nonNull(root) ? maximum(root).key : null;
    }

    private Node maximum(Node node) {
        Node max = null;

        if (!Objects.isNull(node.getRight())) {
            max = maximum(node.right);
        } else {
            max = node;
        }
        return max;
    }

    public V get(T key) {
        Node result = null;
        if (Objects.nonNull(key) && Objects.nonNull(root)) {
            result = get(root, key);
        }
        return Objects.nonNull(result) ? result.value : null;
    }

    private Node get(Node node, T key) {
        Node result = null;
        if (!node.key.equals(key)) {
            if (key.compareTo(node.key) < 0) {
                if (!Objects.isNull(node.getLeft())) {
                    result = get(node.left, key);
                }
            } else {
                if (!Objects.isNull(node.getRight())) {
                    result = get(node.right, key);
                }
            }
        } else {
            result = node;
        }
        return result;
    }

    public Set<T> keySet() {
         Set<T> set = new HashSet<>();
        return inSymmetricalOrderKeys(root, set);
    }

    public Collection<V> values() {
        Collection<V> result = new ArrayList<>();
        return inSymmetricalOrderValues(root, result);
    }

    private Collection<V> inSymmetricalOrderValues(Node localRoot, Collection<V> list) {
        if (localRoot != null) {
            inSymmetricalOrderValues(localRoot.left, list);
            list.add(localRoot.value);
            inSymmetricalOrderValues(localRoot.right, list);
        }
        return list;
    }

    private Set<T> inSymmetricalOrderKeys(Node localRoot, Set<T> list) {
        if (localRoot != null) {
            inSymmetricalOrderKeys(localRoot.left, list);
            list.add(localRoot.key);
            inSymmetricalOrderKeys(localRoot.right, list);
        }
        return list;
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