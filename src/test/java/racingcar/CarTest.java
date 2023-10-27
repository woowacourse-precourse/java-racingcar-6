package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void CarNameSuccessTest() {
        Car car = new Car("ABC");

        Assertions.assertThat(car.getName()).isEqualTo("ABC");
    }

    @Test
    void CarNameFailTest() {

    }
}
