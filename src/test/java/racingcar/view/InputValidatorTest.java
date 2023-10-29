package racingcar.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,", "1.2", "", "1@1"})
    void 리스트로_변환할_수_없을_경우_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputValidator.validateList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "한글", "-1", "0.1"})
    void 정수로_변환할_수_없을_경우_예외를_발생시킨다(String input) {
        assertThatThrownBy(() -> InputValidator.validatePositiveIntegerType(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
