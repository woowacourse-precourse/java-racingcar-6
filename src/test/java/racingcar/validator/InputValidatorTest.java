package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    public void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("자동차 이름이 비어있을 경우 예외가 발생한다.")
    @Test
    void validateCarNameEmptyOrNull() {
        // given
        String names = "";

        // when, then
        assertThatThrownBy(() -> inputValidator.validateCarNameEmptyOrNull(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 1~5 사이가 아닐 경우 예외가 발생한다.")
    @Test
    void validateCarNameLength() {
        // given
        String names = "pobi,lee,yeongJae";

        // when, then
        assertThatThrownBy(() -> inputValidator.validateCarNameLength(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 비어있을 경우 예외가 발생한다.")
    @Test
    void validateTryNumberEmptyOrNull() {
        // given
        String tryTimes = "";

        // when, then
        assertThatThrownBy(() -> inputValidator.validateTryNumberEmptyOrNull(tryTimes))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 숫자로 된 문자열이 아닐 경우 예외가 발생한다.")
    @Test
    void validateTryNumberIsNumber() {
        // given
        String tryTimes = "abc";

        // when, then
        assertThatThrownBy(() -> inputValidator.validateTryNumberIsNumber(tryTimes))
                .isInstanceOf(IllegalArgumentException.class);
    }
}