package algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinimumDifferenceBetweenHighestAndLowestOfKScoresTest {

    @Test
    void kEqualsOneAlwaysZero() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(0, m.minimumDifference(new int[]{5, 3, 8, 1}, 1));
    }

    @Test
    void simpleCase() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(2, m.minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    @Test
    void alreadySortedArray() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(2, m.minimumDifference(new int[]{1, 3, 6, 10}, 2));
    }

    @Test
    void unsortedInput() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(2, m.minimumDifference(new int[]{8, 1, 6, 5, 4}, 3));
    }

    @Test
    void kEqualsArrayLength() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(9, m.minimumDifference(new int[]{1, 10, 5}, 3));
    }

    @Test
    void allValuesEqual() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(0, m.minimumDifference(new int[]{7, 7, 7, 7}, 3));
    }

    @Test
    void minimalArraySize() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(0, m.minimumDifference(new int[]{42}, 1));
    }

    @Test
    void largeGapAtEdges() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(2, m.minimumDifference(new int[]{1, 100, 101, 102}, 3));
    }

    @Test
    void multiplePossibleWindows() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(4, m.minimumDifference(new int[]{2, 8, 12, 16, 20}, 2));
    }

    @Test
    void descendingOrderInput() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(3, m.minimumDifference(new int[]{10, 7, 4, 1}, 2));
    }

    @Test
    void zerosIncluded() {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        assertEquals(1, m.minimumDifference(new int[]{0, 2, 1, 5}, 2));
    }
}