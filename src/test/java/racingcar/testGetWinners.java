package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class testGetWinners {

    @Test
    public void testGetWinners() {
        Car car1 = new Car("Car1");
        car1.move(1);
        Car car2 = new Car("Car2");
        car2.move(3);
        Car car3 = new Car("Car3");
        car3.move(2);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<String> winners = Application.getWinners(cars);

        assertThat(winners).containsExactly("Car2");
    }
}

