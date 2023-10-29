package racingcar.Entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void run_메서드_실행후_step값_검증() {
        Car car = new Car("cc", 3);
        car.run();

        assertThat(car.getStep()).isIn(3, 4);
    }
}