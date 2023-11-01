package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    @DisplayName("자동차 이름 5자 초과시 오류")
    @Test
    void filterCarNameOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.filterCarName(List.of("abcdef")));
    }

    @DisplayName("자동차 이름 중복 입력시 오류")
    @Test
    void filterCarNameDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.filterCarName(List.of("pobi", "woni", "jun", "pobi")));
    }

    @DisplayName("자동차 이름 입력 안 한 경우 오류")
    @Test
    void filterCarNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.filterCarName(List.of("")));
    }

    @DisplayName("시도 횟수 입력값이 정수가 아닌 경우 오류")
    @Test
    void filterNumberOfAttempNotNumeric() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.filterNumberOfAttempt("abc"));
    }

    @DisplayName("시도 횟수 입력값이 음수일 경우 오류")
    @Test
    void filterNumberOfAttemptNegative() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.filterNumberOfAttempt("-1"));
    }
}