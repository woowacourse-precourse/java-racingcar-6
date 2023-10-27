package racingcar.view.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력이 null 이거나 공백이면 예외가 발생한다.")
    void validateInput(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백일 수 없습니다.");
    }
}