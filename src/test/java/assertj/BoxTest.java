package assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }
    @Test
    void isThisUnknown() {
        Box box = new Box(110, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("Unknown object");
    }
    @Test
    void isCubeArea5x5Equals150() {
        Box box = new Box(8, 5);
        assertThat(box.getArea())
                .isNotZero()
                .isPositive()
                .isGreaterThan(130.0d)
                .isLessThan(155.0d)
                .isEqualTo(150.0d);
    }

    @Test
    void isTetrahedronArea5x5Equals43dot3() {
        Box box = new Box(4, 5);
        assertThat(box.getArea())
                .isNotZero()
                .isEqualTo(43.301d, withPrecision(0.002d))
                .isCloseTo(43.3d, withPrecision(0.01d))
                .isCloseTo(43d, Percentage.withPercentage(1.0d))
                .isGreaterThan(43.29d)
                .isLessThan(43.4d);
    }

    @Test
    void isSphereVerticesEquals0() {
        Box box = new Box(0, 6);
        assertThat(box.getNumberOfVertices())
                .isZero()
                .isEqualTo(0);
    }

    @Test
    void isTetrahedronEquals4() {
        Box box = new Box(4, 6);
        assertThat(box.getNumberOfVertices())
                .isNotZero()
                .isPositive()
                .isLessThan(6)
                .isGreaterThan(1)
                .isEqualTo(4);
    }
    @Test
    void isExistTetrahedron() {
        Box box = new Box(4, 9);
        assertThat(box.getNumberOfVertices())
                .isNotZero()
                .isPositive()
                .isLessThan(6)
                .isGreaterThan(1)
                .isEqualTo(4);
    }

    @Test
    void isExistFigure() {
        Box box = new Box(4, 9);
        assertThat(box.isExist())
                .isEqualTo(true)
                .isTrue();
    }

    @Test
    void isNotExistFigure() {
        Box box = new Box(-1, 9);
        assertThat(box.isExist())
                .isEqualTo(false)
                .isFalse();
    }
}