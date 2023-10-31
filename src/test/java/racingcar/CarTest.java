package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void moveFowrard_자동차_전진() {
        Car car = new Car("abc");

        int pre = car.getMoveIndex();
        car.moveFowrard();

        assertThat(car.getMoveIndex()).isEqualTo(pre + 1);
    }

    @Test
    void stop_자동차_멈춤() {
        Car car = new Car("abc");

        int pre = car.getMoveIndex();
        car.stop();

        assertThat(car.getMoveIndex()).isEqualTo(pre);
    }
}
