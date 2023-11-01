package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_전진_후_위치_확인() {
        Car car = new Car("pobi");
        car.moveOrNot(MOVING_FORWARD);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤_후_위치_확인() {
        Car car = new Car("woni");
        car.moveOrNot(STOP);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}