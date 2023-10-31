package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.PlayIterator;
import racingcar.global.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayIteratorTest {
    @Test
    @DisplayName("시도할 횟수가 숫자가 아닐 경우 예외 발생")
    void fromNotNumericPlayCountString() {
        assertThatThrownBy(() -> PlayIterator.from("다섯"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMERIC_PLAY_COUNT_STRING.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 음수일 경우 예외 발생")
    void fromNegativePlayCount() {
        assertThatThrownBy(() -> PlayIterator.from("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_PLAY_COUNT.getMessage());
    }

    @Test
    @DisplayName("반복자가 횟수만큼 작동")
    void playCorrectly() {
        int count = 0;
        PlayIterator iterator = PlayIterator.from(" 5 ");
        while (iterator.isPlayable()) {
            iterator.play();
            count++;
        }
        assertThat(count).isEqualTo(5);
    }
}
