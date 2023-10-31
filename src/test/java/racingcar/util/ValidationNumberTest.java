package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ExceptionMessages;
import racingcar.util.ValidationNumber;

class ValidationNumberTest {

    @ParameterizedTest
    @DisplayName("입력이 없는지 테스트한다.")
    @ValueSource(strings = { "", " ", "   ", "       " })
    void validateIsEmpty(String inputString) {
        IllegalArgumentException lengthException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationNumber.validateIsEmpty(inputString);
        });
        assertThat(lengthException.getMessage()).isEqualTo(ExceptionMessages.EMPTY.getExceptionMessage());
    }

    @ParameterizedTest
    @DisplayName("입력문자열이 숫자가 아닌지 테스트한다.")
    @ValueSource(strings = { "a", "1a", "a123", "14e8", "1e1" })
    void validateIsNumber(String inputString) {
        IllegalArgumentException lengthException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationNumber.validateIsNumber(inputString);
        });
        assertThat(lengthException.getMessage()).isEqualTo(ExceptionMessages.NOT_NUMBER.getExceptionMessage());
    }
}