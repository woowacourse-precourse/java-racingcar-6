package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static racingcar.util.InputDataValidator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputDataValidatorTest {
    @Test
    @DisplayName("이름 5글자 초과 시 예외 발생")
    void testNameSizeOverFive() {
        assertThatThrownBy(() -> validateInputSize("asdfgh"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 공백 포함 시 예외 발생")
    void testNameHasSpace() {
        assertThatThrownBy(() -> validateHasSpace("asd fgh"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수 숫자 아닐 경우 예외 발생")
    void testIsNotInteger() {
        assertThatThrownBy(() -> validateIsInteger("asdfgh"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}