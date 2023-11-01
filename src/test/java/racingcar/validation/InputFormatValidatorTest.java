package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.configuration.InputFormatConfig.INVALID_NUMBER_FORMAT_EXCEPTION;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_EXCESS_EXCEPTION;

class InputFormatValidatorTest {

    @DisplayName("5글자를 초과하는 자동차 이름을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"123456", "가나다라마바사", "abcdef", "12ab가나"})
    void validateLengthOfName(String carName) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateLengthOfName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_EXCESS_EXCEPTION);
    }

    @DisplayName("양의 정수가 아닌 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "가나다라마바사", "abcdef", "12ab가나", "ab12가나", "-1"})
    void validateNumberFormat(String input) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_FORMAT_EXCEPTION);
    }

}
