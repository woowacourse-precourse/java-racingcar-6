package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameRoundTest {

    @Test
    void 정수를_통해_레이스를_생성할_수_있다() {
        // given
        String input = "3";

        // when
        GameRound gameRound = new GameRound(input);

        // then
        assertEquals(3, gameRound.roundNumber());
    }

    @Test
    void 레이스_횟수가_숫자가_아니면_예외를_발생한다() {
        // given
        String input = "string";

        // when, then
        Assertions.assertThatThrownBy(() -> new GameRound(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이스_횟수가_정수가_아니면_예외를_발생한다() {
        // given
        String input = "3.3";

        // when, then
        Assertions.assertThatThrownBy(() -> new GameRound(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이스_횟수가_양의_정수가_아니면_예외를_발생한다() {
        // given
        String input = "0";

        // when, then
        Assertions.assertThatThrownBy(() -> new GameRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주는 최소 1라운드부터 가능합니다.");
    }
}