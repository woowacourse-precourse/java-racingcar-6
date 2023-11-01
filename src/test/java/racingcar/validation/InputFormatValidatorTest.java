package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

}
