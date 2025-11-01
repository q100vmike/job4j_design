package collection.binarytree;

import collection.binarytree.avl.AvlTree;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AvlTreeTest {

    @Test
    void simmetricalOrderIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void leftRotationIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{10, 5, 30, 20, 50, 40, 60}) {
            tree.insert(element);
        }
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(5, 10, 20, 30, 40, 50, 60);
    }

    @Test
    void rightRotationIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{50, 30, 10, 40}) {
            tree.insert(element);
        }
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(10, 30, 40, 50);
    }
}