package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ExceptionMessage.PLAY_COUNT_VALUE_EXCEPTION;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.PlayCount;

public class PlayCountTest {

    @Test
    void 횟수는_양수일_때_가능하다() {
        // given & when
        PlayCount count = PlayCount.from("5");
    }

    @Test
    void 횟수는_음수일_수_없다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           PlayCount count = PlayCount.from("-3");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(PLAY_COUNT_VALUE_EXCEPTION.toString());
    }

    @Test
    void 횟수는_숫자여야_한다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayCount count = PlayCount.from("abc");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(PLAY_COUNT_VALUE_EXCEPTION.toString());
    }
}
