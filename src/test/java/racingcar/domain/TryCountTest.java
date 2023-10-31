package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.NEGATIVE_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.message.ErrorMessage.NUMBER_FORMAT_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("시도할 횟수가 숫자 일 때 성공")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "4", "6", "7", "9", "15"})
    void 시도_횟수_숫자_성공(String value) {
        assertThatCode(() -> new TryCount(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("시도할 횟수가 숫자가 아닐 시 실패")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", ""})
    void 시도_횟수_숫자_실패(String value) {
        assertThatThrownBy(() -> new TryCount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_FORMAT_EXCEPTION_MESSAGE);
    }

    @DisplayName("시도할 횟수가 음수 일 때 실패")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-5"})
    void 시도_횟수_음수_실패(String value) {
        assertThatThrownBy(() -> new TryCount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
    }
}