package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.view.exception.InputException.PLAY_COUNT_VALUE_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayCountTest {

    @Test
    @DisplayName("정상적인 횟수를 입력했을 시 문제 없어야 한다.")
    void validNumberInputTest() {
        // when & then
        assertDoesNotThrow(() -> PlayCount.createDefault("5"));
    }

    @Test
    @DisplayName("음수를 입력했을 시 예외가 발생한다.")
    void negativeNumberInputExceptionTest() {
        // when & then
        assertThatThrownBy(() -> PlayCount.createDefault("-5")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAY_COUNT_VALUE_EXCEPTION.getMessage());
    }
}
