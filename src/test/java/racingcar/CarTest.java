package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void carNameTest() {
        Car car = new Car("car");
        Assertions.assertThat(car.getName()).isEqualTo("car");
    }

    @Test
    void carRunTest() {
        Car car = new Car("car");
        car.run();
        Assertions.assertThat(car.getPosition()).isLessThanOrEqualTo(1);
    }

    @Test
    void carNameOver5() {
        Assertions.assertThatThrownBy(() -> new Car("santa fe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void positionBar() {
        Car car = new Car("car");

        while (car.getPosition() != 3) {
            car.run();
        }

        String positionBar = car.getPositionBar();
        Assertions.assertThat(positionBar).isEqualTo("---");
    }
}
