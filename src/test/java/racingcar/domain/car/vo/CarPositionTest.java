package racingcar.domain.car.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {
    @Test
    @DisplayName("CarPosition은 0으로 초기화된다.")
    void init() {
        // given
        CarPosition carPosition = new CarPosition();

        // when
        int position = carPosition.getPosition();

        // then
        assertThat(position).isZero();
    }

    @Test
    @DisplayName("move를 하면 position이 1 증가한다.")
    void move() {
        // given
        CarPosition carPosition = new CarPosition();

        // when
        carPosition.move();

        // then
        assertThat(carPosition.getPosition()).isEqualTo(1);
    }
}
