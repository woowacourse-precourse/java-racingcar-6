package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.messages.ErrorMessage.CAR_NAMES_NOT_UNIQUE;
import static racingcar.messages.ErrorMessage.CAR_NAME_LENGTH_OUT_OF_RANGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    InputValidator validator = InputValidator.getInstance();

    @DisplayName("중복된 이름이 주어지면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"jun,jun,pobi", "pobi, woni , jun ,woni"})
    void validateNameDuplication(String input) {
        assertThatThrownBy(() -> validator.validateNameDuplication(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAMES_NOT_UNIQUE);
    }

    @DisplayName("이름 길이가 1 미만 혹은 5 초과일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcedf,jun,pobi", "", ",jun"})
    void validateNameLengthRange(String input) {
        assertThatThrownBy(() -> validator.validateNameLengthRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_OUT_OF_RANGE);
    }
}