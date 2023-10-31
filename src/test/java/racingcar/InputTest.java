package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void divideNames() {
        String s = "a,b,c";
        String[] strings = Application.divideNames(s);
        assertThat(strings).containsExactly("a","b","c");
    }

    @Test
    void moreThanFiveLetter() {
        String s = "abcdef";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.moreThanFiveLetter(s));
    }
}