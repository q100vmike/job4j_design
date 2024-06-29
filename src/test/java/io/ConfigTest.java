package io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithEmptyAndComment() {
        String path = "data/pair_with_comment_and_empty.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithEmptyEqualsValue() throws IllegalArgumentException {
        String path = "data/pair_with_exception1.properties";
        Config config = new Config(path);
        String expectedMessage = "not possible inside yml file!";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> config.load());
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenPairWithKeyEqualsEmpty() throws IllegalArgumentException {
        String path = "data/pair_with_exception2.properties";
        Config config = new Config(path);
        String expectedMessage = "not possible inside yml file!";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> config.load());
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenPairWithNoEqualString() throws IllegalArgumentException {
        String path = "data/pair_with_exception3.properties";
        Config config = new Config(path);
        String expectedMessage = "not possible inside yml file!";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> config.load());
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenPairWithOnlyEqualString() throws IllegalArgumentException {
        String path = "data/pair_with_exception4.properties";
        Config config = new Config(path);
        String expectedMessage = "not possible inside yml file!";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> config.load());
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenPairWithKeyEqualStringEqual() throws IllegalArgumentException {
        String path = "data/pair_with_key_equal_val_equal_empty.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev=");
    }
}