package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class NameTest {

    @Test
    void 자동차이름의_길이가_1_미만일_경우_예외를_터트린다() {
        assertThrows(IllegalArgumentException.class, () -> new Name(""));
    }

    @Test
    void 자동차이름의_길이가_5_초과일_경우_예외를_터트린다() {
        assertThrows(IllegalArgumentException.class, () -> new Name("다섯글자이상"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    void 자동차이름의_길이가_1이상_5이하일_경우_예외가_발생하지_않는다(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }
}
