package racingcar.domain.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}