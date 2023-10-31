package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static racingcar.util.InputDataValidator.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputDataValidatorTest {
    @Test
    @DisplayName("이름 5글자 초과 시 예외 발생")
    void testNameSizeOverFive() {
        List<String> stringList = new ArrayList<>();
        stringList.add("SizeOver");

        assertThatThrownBy(() -> validateInputSize(stringList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 공백 일 경우 예외 발생")
    void testNameEmpty() {
        List<String> stringList = new ArrayList<>();
        stringList.add("");
        stringList.add("blur");

        assertThatThrownBy(() -> validateInputSize(stringList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 공백 포함 시 예외 발생")
    void testNameHasSpace() {
        assertThatThrownBy(() -> validateHasSpace("asd fgh"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 자동차 이름 입력 시 예외 없는지 확인")
    void testCorrectMessage() {
        assertThatCode(() -> validateHasSpace("asd"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수 숫자 아닐 경우 예외 발생")
    void testIsNotInteger() {
        assertThatThrownBy(() -> validateIsInteger("asdfgh"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 횟수 입력 시 예외 없는지 확인")
    void testCorrectInputCount() {
        assertThatCode(() -> validateHasSpace("1"))
                .doesNotThrowAnyException();
    }
}