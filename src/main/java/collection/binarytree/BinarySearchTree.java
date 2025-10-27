package collection.binarytree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public boolean put(T key) {
        boolean result;
        if (Objects.isNull(root)) {
            root = new Node(key);
            result = true;
        } else {
            result = put(root, key);
        }
        return result;
    }

    private boolean put(Node node, T key) {
        boolean result = false;
        Node newNode = new Node(key);

        if (key.compareTo(node.key) < 0) {
            if (Objects.isNull(node.getLeft())) {
                node.setLeft(newNode);
                result = true;
            } else {
                result = this.put(node.left, key);
            }
        } else {
            if (Objects.isNull(node.getRight())) {
                node.setRight(newNode);
                result = true;
            } else {
                result = this.put(node.right, key);
            }
        }

        return result;
    }

    public boolean contains(T key) {
        Node result = find(root, key);
        return Objects.nonNull(result);
    }

    private Node find(Node node, T key) {
        Node result = null;
        if (!node.key.equals(key)) {
            if (key.compareTo(node.key) < 0) {
                 if (!Objects.isNull(node.getLeft())) {
                    result = find(node.left, key);
                }
            } else {
                if (!Objects.isNull(node.getRight())) {
                    result = find(node.right, key);
                }
            }
        } else {
            result = node;
        }
        return result;
    }

    public boolean remove(T key) {
        /* Метод будет реализован в следующих уроках */
        return false;
    }

    public List<T> inSymmetricalOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inSymmetricalOrder(node, result);
    }

    private List<T> inSymmetricalOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inSymmetricalOrder(localRoot.left, list);
            list.add(localRoot.key);
            inSymmetricalOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPreOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inPreOrder(node, result);
    }

    private List<T> inPreOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            list.add(localRoot.key);
            inPreOrder(localRoot.left, list);
            inPreOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPostOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inPostOrder(node, result);
    }

    private List<T> inPostOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inPostOrder(localRoot.left, list);
            inPostOrder(localRoot.right, list);
            list.add(localRoot.key);
        }
        return list;
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
            max = maximum((Node) node.getRight());
        } else {
            max = node;
        }
        return max;
    }

    @Override
    public String toString() {
        return PrintTree.getTreeDisplay(root);
    }

    private class Node implements VisualNode {
        private T key;
        private Node left;
        private Node right;

        public Node(T key) {
            this.key = key;
        }

        @Override
        public VisualNode getLeft() {
            return left;
        }

        @Override
        public VisualNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return key.toString();
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}