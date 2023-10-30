package racingcar.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 게임_상수_테스트() {
        assertAll(
                () -> assertThat(Game.MIN_RANDOM_NUMBER.is()).isEqualTo(0),
                () -> assertThat(Game.MAX_RANDOM_NUMBER.is()).isEqualTo(9),
                () -> assertThat(Game.MIN_NAME_LENGTH.is()).isEqualTo(1),
                () -> assertThat(Game.MAX_NAME_LENGTH.is()).isEqualTo(5),
                () -> assertThat(Game.MOVE_CONDITION.is()).isEqualTo(4)
        );
    }
}
