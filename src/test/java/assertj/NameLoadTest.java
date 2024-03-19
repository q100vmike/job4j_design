package assertj;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkNamesIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkParseNoEqual() {
        NameLoad nameLoad = new NameLoad();
        String word1 = "name=Mike";
        String word2 = "name=Serg";
        String word3 = "name Pol";
        String word4 = "name=Gleb";

        assertThatThrownBy(() -> nameLoad.parse(word1, word2, word3, word4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word3)
                .hasMessageContaining("not contain the symbol");
    }

    @Test
    void checkParseNoKey() {
        NameLoad nameLoad = new NameLoad();
        String word1 = "name=Mike";
        String word2 = "name=Serg";
        String word3 = "name=Pol";
        String word4 = "=Gleb";

        assertThatThrownBy(() -> nameLoad.parse(word1, word2, word3, word4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word4)
                .hasMessageContaining("does not contain a key");
    }

    @Test
    void checkParseNoValue() {
        NameLoad nameLoad = new NameLoad();
        String word1 = "name=Mike";
        String word2 = "name=";
        String word3 = "name=Pol";
        String word4 = "name=Gleb";

        assertThatThrownBy(() -> nameLoad.parse(word1, word2, word3, word4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word2)
                .hasMessageContaining("does not contain a value");
    }
}