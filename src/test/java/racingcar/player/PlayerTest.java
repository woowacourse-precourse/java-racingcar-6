package racingcar.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

class PlayerTest {

    @Test
    void moveOnInput_메서드_사용시_0보다_큰_정수_아니면_예외_발생() {
        Player player = new Player();

        assertThatThrownBy(() -> player.moveOnInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MOVE_OF_RANGE);
    }
}