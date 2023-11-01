package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberOfTimesValidatorTest {

    Validator<String> numberValidator = new NumberOfTimesValidator();

    @Test
    @DisplayName("정상적인 이동 횟수")
    void validateNumberOfTimesSuccess() {
        String input = "10";
        assertDoesNotThrow(() -> numberValidator.validate(input));
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    void validateNumberOfTimesNotNumber() {
        String input = "2147483647L";
        assertThatThrownBy(() -> numberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력 - 빈 문자열")
    void validateNumberOfTimesNotNumberEmptyString() {
        String input = "";
        assertThatThrownBy(() -> numberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력 - 공백 문자열")
    void validateNumberOfTimesNotNumberWhitespaceString() {
        String input = " 123";
        assertThatThrownBy(() -> numberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("유효하지 않은 이동 횟수 입력 - 너무 큰 수")
    void validateNumberOfTimesBigNumber() {
        String input = "2147483648";
        assertThatThrownBy(() -> numberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자 범위가 아닙니다.");
    }

    @Test
    @DisplayName("유효하지 않은 이동 횟수 입력 - 너무 작은 수")
    void validateNumberOfTimesSmallNumber() {
        String input = "0";
        assertThatThrownBy(() -> numberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자 범위가 아닙니다.");
    }

    @Test
    @DisplayName("유효하지 않은 이동 횟수 입력 - 음수")
    void validateNumberOfTimesNegativeNumber() {
        String input = "-1";
        assertThatThrownBy(() -> numberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자 범위가 아닙니다.");
    }
}