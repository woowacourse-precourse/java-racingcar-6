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

    record Name(String name) {
        Name {
            if (name.length() < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

}
