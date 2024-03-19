package assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .startsWith("first")
                .endsWith("five")
                .contains("three", Index.atIndex(2))
                .containsAnyOf("zero", "second", "ten", "four")
                .doesNotContain("first", Index.atIndex(1))
                .doesNotContainNull()
                .containsSubsequence("three", "four", "five");
    }
    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .isNotEmpty()
                .containsKey("three")
                .containsKeys("first", "second")
                .containsEntry("three", 2)
                .doesNotContainKey("foo")
                .doesNotContainValue(100);
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> array = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("three")
                .containsAnyOf("zero", "second", "ten", "four")
                .containsOnlyOnce("three")
                .doesNotContain("foo")
                .doesNotContainNull();
    }

}