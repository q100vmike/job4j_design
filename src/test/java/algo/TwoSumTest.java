package algo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {

    @Test
    void simpleCase() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{0, 1}, t.twoSum(new int[]{2, 7}, 9));
    }

    @Test
    void numbersInMiddle() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{1, 3}, t.twoSum(new int[]{1, 3, 5, 7}, 10));
    }

    @Test
    void negativeNumbers() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{0, 2}, t.twoSum(new int[]{-3, 4, 1}, -2));
    }

    @Test
    void mixPositiveAndNegative() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{1, 2}, t.twoSum(new int[]{10, -2, 12}, 10));
    }

    @Test
    void zeroTarget() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{0, 1}, t.twoSum(new int[]{0, 0}, 0));
    }

    @Test
    void duplicateValues() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{0, 1}, t.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    void answerAtEnd() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{2, 4}, t.twoSum(new int[]{5, 1, 7, 8, 3}, 10));
    }

    @Test
    void answerAtBeginning() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{0, 2}, t.twoSum(new int[]{4, 6, 5}, 9));
    }

    @Test
    void largeValues() {
        TwoSum t = new TwoSum();
        assertArrayEquals(
                new int[]{1, 2},
                t.twoSum(new int[]{1_000_000_000, -500_000_000, 500_000_000}, 0)
        );
    }

    @Test
    void unorderedArray() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{1, 4}, t.twoSum(new int[]{8, 2, 11, 15, 6}, 8));
    }

    @Test
    void minimalLengthArray() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{0, 1}, t.twoSum(new int[]{1, -1}, 0));
    }

    @Test
    void negativeTarget() {
        TwoSum t = new TwoSum();
        assertArrayEquals(new int[]{0, 3}, t.twoSum(new int[]{-5, 2, 8, -3}, -8));
    }
}