package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.CarTest.FORWARD_NUMBER;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("우승_자동차_탐색")
    @Test
    void 우승_자동차_탐색() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("yeon");
        Car car3 = new Car("jjang");
        car1.forward(FORWARD_NUMBER);
        car2.forward(FORWARD_NUMBER);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        assertThat(cars.winner()).containsExactly(car1, car2);
    }
}