package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("차를 처음 생성 시 전진 카운트는 0이다.")
    @Test
    void init() {
        // when
        Car car = Car.nameOf(CarName.from("haero"));

        // then
        assertThat(car.getForwardCount()).isEqualTo(0L);
    }

    @DisplayName("차를 전진 시키면 전진 카운트가 1만큼 증가한다.")
    @Test
    void moveForward() {
        // given
        Car car = Car.nameOf(CarName.from("haero"));

        // when
        car.moveForward();

        // then
        assertThat(car.getForwardCount()).isEqualTo(1L);
    }

}
