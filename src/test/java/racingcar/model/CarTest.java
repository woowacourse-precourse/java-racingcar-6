package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 전진() {
        Car car = new Car("car");

        car.goForward();

        assertThat(car.getStep()).isEqualTo("-");
    }
}
