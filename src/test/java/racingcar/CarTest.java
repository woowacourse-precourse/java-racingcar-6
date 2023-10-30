package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void carNameTest() {
        Car car = new Car("santa fe");
        Assertions.assertThat(car.getName()).isEqualTo("santa fe");
    }

    @Test
    void carRunTest() {
        Car car = new Car("santa fe");
        car.run();
        Assertions.assertThat(car.getPosition()).isLessThanOrEqualTo(1);
    }
}
