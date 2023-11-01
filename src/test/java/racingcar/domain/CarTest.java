package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    public void 자동차_생성_테스트() {
        // given
        Car car = new Car("test");

        // when, then
        assertThat(car).isEqualTo(new Car("test"));
    }

    @Test
    public void 자동차_전진_테스트() {
        // given
        Car car = new Car("test");

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
