package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.ExceptionMessage.PLAY_COUNT_VALUE_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.PlayCount;

public class PlayCountTest {

    @Test
    @DisplayName("횟수는 양수일 때 가능하다")
    void positiveCountValueTest() {
        // given & when & then
        assertDoesNotThrow(() -> {
            PlayCount count = PlayCount.from("5");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "abc"})
    @DisplayName("횟수는 음수거나 일반 문자면 안된다")
    void negativeOrNotNumericCountValueExceptionTest(final String value) {
        // given & when & then
        assertThatThrownBy(() -> {
           PlayCount count = PlayCount.from(value);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAY_COUNT_VALUE_EXCEPTION.getMessage());
    }
}
