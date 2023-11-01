package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

public class TryNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1", "abc", "+*&", "0"})
    @DisplayName("시도 횟수 문자거나, 음수거나, 0이면 실패")
    public void validateTryNumber_실패(String input) {
        assertThatThrownBy(() -> InputView.validateTryNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1000000000"})
    @DisplayName("시도 횟수 양수 정수이면 성공")
    public void validateTryNumber_성공(String input) {
        assertThat(InputView.validateTryNumber(input)).isTrue();
    }
}