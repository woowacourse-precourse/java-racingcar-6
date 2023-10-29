package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.PLAY_COUNT_VALUE_EXCEPTION;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.PlayCount;

public class PlayCountTest {

    @Test
    void 횟수는_양수일_때_가능하다() {
        // given & when & then
        Assertions.assertDoesNotThrow(() -> {
            PlayCount count = PlayCount.from("5");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "abc"})
    void 횟수는_음수거나_일반_문자면_안된다(final String value) {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           PlayCount count = PlayCount.from(value);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(PLAY_COUNT_VALUE_EXCEPTION.toString());
    }
}
