package iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterLast() {
        ListUtils.addAfter(input, 1, 4);
        assertThat(input).hasSize(3).containsSequence(1, 3, 4);
    }

    @Test
    void whenRemoveIfGraterThe3() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        ListUtils.removeIf(input, p -> p > 3);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIfEquals2() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        ListUtils.removeIf(input, p -> p == 2);
        assertThat(input).hasSize(4).containsSequence(1, 3, 4, 5);
    }
    @Test
    void whenReplaceIfEquals2() {
        ListUtils.addAfter(input, 0, 7);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        ListUtils.replaceIf(input, p -> p == 7, 2);
        assertThat(input).hasSize(5).containsSequence(1, 2, 3, 4, 5);
    }

    @Test
    void whenReplaceIfLess3Then0() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        ListUtils.replaceIf(input, p -> p <= 3, 0);
        assertThat(input).hasSize(5).containsSequence(0, 0, 0, 4, 5);
    }

    @Test
    void whenRemoveAll123() {
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        ListUtils.removeAll(input, elements);
        assertThat(input).hasSize(2).containsSequence(4, 5);
    }

    @Test
    void whenRemoveAll45() {
        List<Integer> elements = new ArrayList<>(Arrays.asList(4, 5));
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        ListUtils.removeAll(input, elements);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveAll234() {
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 3, 4));
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        ListUtils.removeAll(input, elements);
        assertThat(input).hasSize(2).containsSequence(1, 5);
    }
}