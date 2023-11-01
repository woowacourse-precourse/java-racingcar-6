package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Position 클래스")
class PositionTest {

    private Position position;
    private final int INIT_POSITION_CRITERION = 0;
    private final int MOVING_FORWARD_CRITERION = 4;
    private final int STOP_CRITERION = 3;

    @BeforeEach
    void setup() {
        position = new Position();
    }

    @Test
    void Position_생성시_자동으로_초기값_생성() {
        assertThat(position.getPosition()).isEqualTo(INIT_POSITION_CRITERION);
    }

    @Test
    void move_메소드_호출시_위치가_1_증가() {
        position.move();
        assertThat(position.getPosition()).isEqualTo(INIT_POSITION_CRITERION + 1);
    }

    @Test
    void 무작위_값이_4_이상이면_이동_가능() {
        assertThat(position.isMovable(MOVING_FORWARD_CRITERION)).isTrue();
    }

    @Test
    void 무작위_값이_4_미만이면_이동_불가능() {
        assertThat(position.isMovable(STOP_CRITERION)).isFalse();
    }

}