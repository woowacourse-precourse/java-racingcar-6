package racingcar.utill;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utill.Validator.validateAttemptNumber;
import static racingcar.utill.Validator.validateCarsName;
import static racingcar.utill.Validator.validateNullInput;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Validator 테스트")
class ValidatorTest {

    @DisplayName("null 입력 검증 테스트")
    @Test
    void validateNullInputTest() {
        //given
        String nullString = null;

        //when, then
        assertThrows(IllegalArgumentException.class, () -> validateNullInput(nullString));
    }

    @DisplayName("자동차 이름 입렵 검증 테스트")
    @Test
    void ValidateCarsNameTest() {
        //given
        String blank = "a,,";
        String duplicate = "a,a,a,a,a,a,a";
        String sixLength = "aaaaaa";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> validateCarsName(blank));
        assertThrows(IllegalArgumentException.class, () -> validateCarsName(duplicate));
        assertThrows(IllegalArgumentException.class, () -> validateCarsName(sixLength));
    }

    @DisplayName("시도 횟수 입력 검증 테스트")
    @Test
    void validateAttemptNumberTest() {
        //given
        String alphabet = "a";
        String minus = "-1";
        String floatNumber = "0.1";

        //when , then
        assertThrows(IllegalArgumentException.class, () -> validateAttemptNumber(alphabet));
        assertThrows(IllegalArgumentException.class, () -> validateAttemptNumber(minus));
        assertThrows(IllegalArgumentException.class, () -> validateAttemptNumber(floatNumber));
    }
}