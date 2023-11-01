package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    void run() {
        Judgment judgment = new Judgment();

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        cars.add(car1);
        cars.add(car2);

        Racing racing = new Racing(cars);
        racing.run(judgment, 5);
        Assertions.assertThat(car1.currentLocation()).isEqualTo("Car1 : -");
        Assertions.assertThat(car2.currentLocation()).isEqualTo("Car2 : -");
    }
}