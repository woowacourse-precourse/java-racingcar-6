package racingcar.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.handler.ErrorHandler;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TryCountTest {

    @DisplayName("숫자로 변환할 수 없는 값이 들어오면 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0}")
    @ValueSource(strings = {"한", "^", "0.1"})
    void createTryCountWithInvalidNumber(String input) {
        assertThatThrownBy(() -> TryCount.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_NUMBER.getException().getMessage());
    }

    @DisplayName("1보다 작은 숫자가 입력되면 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input : {0}")
    @ValueSource(strings = {"-1", "0"})
    void createTryCountWithInvalidRange(String input) {
        assertThatThrownBy(() -> TryCount.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_RANGE.getException().getMessage());
    }
}
