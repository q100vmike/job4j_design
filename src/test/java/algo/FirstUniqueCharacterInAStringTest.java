package algo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstUniqueCharacterInAStringTest {

    @Test
    void simpleUniqueAtBeginning() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(0, f.firstUniqChar("leetcode"));
    }

    @Test
    void uniqueInMiddle() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(2, f.firstUniqChar("loveleetcode"));
    }

    @Test
    void uniqueAtEnd() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(6, f.firstUniqChar("aabbccd"));
    }

    @Test
    void noUniqueCharacters() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(-1, f.firstUniqChar("aabbcc"));
    }

    @Test
    void singleCharacterString() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(0, f.firstUniqChar("z"));
    }

    @Test
    void allCharactersUnique() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(0, f.firstUniqChar("abcdef"));
    }

    @Test
    void repeatedThenUniqueLater() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(4, f.firstUniqChar("aabbcde"));
    }

    @Test
    void manyRepeatsBeforeUnique() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(11, f.firstUniqChar("aaaabbbbcccd"));
    }

    @Test
    void uniqueCharacterAfterManyDuplicates() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(10, f.firstUniqChar("zzzzzzzzzza"));
    }

    @Test
    void alternatingDuplicates() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        assertEquals(-1, f.firstUniqChar("abababab"));
    }

    @Test
    void largeStringSingleUnique() {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        String s = "a".repeat(1000) + "b" + "a".repeat(1000);
        assertEquals(1000, f.firstUniqChar(s));
    }
}