package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.anyOf;

class CarTest {

    @Test
    void run_메서드_실행후_step값_검증() {
        Car car = new Car("cc", 3);
        car.run();

        Assertions.assertThat(car.getStep()).isIn(3, 4);
    }

}