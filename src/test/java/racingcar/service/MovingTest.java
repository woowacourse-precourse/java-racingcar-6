package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.common.Size;

import static org.assertj.core.api.Assertions.assertThat;

class MovingTest {
    Moving moving = new Moving();

    @Test
    void 전진_실패_경계값_미만() {
        int boundary = Size.MOVING_BOUNDARY.getValue() - 1;
        assertThat(moving.decide(boundary, boundary)).isFalse();
    }

    @Test
    void 전진_성공_경계값_이상() {
        int boundary = Size.MOVING_BOUNDARY.getValue();
        assertThat(moving.decide(boundary, boundary)).isTrue();
    }

}