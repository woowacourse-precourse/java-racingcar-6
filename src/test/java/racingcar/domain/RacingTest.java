package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    void run() {
        Judgment judgment = new Judgment();
        NumberGenerator numberGenerator = new NumberGenerator();

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        cars.add(car1);
        cars.add(car2);

        Racing racing = new Racing(cars);
        racing.run(judgment, numberGenerator);
        String car1CurrentLocation = car1.currentLocation();
        String car2CurrentLocation = car2.currentLocation();

        Assertions.assertThat(car1CurrentLocation).isIn("Car1 : -", "Car1 : ");
        Assertions.assertThat(car2CurrentLocation).isIn("Car2 : -", "Car2 : ");
    }
}