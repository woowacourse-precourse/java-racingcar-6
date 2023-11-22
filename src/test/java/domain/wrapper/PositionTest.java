package domain.wrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.wrapper.Position;

import static racingcar.domain.constant.CarConstant.INIT_POSITION;
import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position position;

    @BeforeEach
    void init() {
        position = Position.create();
    }

    @Test
    @DisplayName("초기 CarPosition 객체 생성 시 position은 1이어야 한다.")
    void givenNormalPosition_thenSuccess() {
        // given, when
        int currentPosition = position.getPosition();

        // then
        assertThat(position)
                .isInstanceOf(Position.class);

        assertThat(currentPosition)
                .isEqualTo(INIT_POSITION.getValue());
    }

    @Test
    @DisplayName("위치 값을 1 증가시킨다.")
    void whenAddPosition_thenPositionPlus() {
        // given
        int beforePosition = position.getPosition();

        // when
        position.addPosition();

        // then
        assertThat(position.getPosition())
                .isEqualTo(beforePosition + 1);
    }
}