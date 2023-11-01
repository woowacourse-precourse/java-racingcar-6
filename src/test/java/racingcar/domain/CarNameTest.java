package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 null인 경우 예외 발생")
    void carNameBlankExceptionTest(final String name) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> CarName.from(name));
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과한 경우 예외 발생")
    void carNameLengthOverValidationExceptionTest() {
        // given
        final String name = "car name test";

        // expected
        assertThrows(IllegalArgumentException.class, () -> CarName.from(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("올바른 이름인 경우 정상 동작")
    void validCarNameTest(final String name) {
        // expected
        assertDoesNotThrow(() -> CarName.from(name));
    }
}