package self;

import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MethodTest {

    @Test
    void car() {
        Car car = new Car("poby");
        Car car2 = new Car("woni");
        car2.setSteps(3);

        assertThat(car.getSteps()).isEqualTo(0);
        assertThat(car2.getSteps()).isEqualTo(3);
    }

    @Test
    void checkWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("poby"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));
        cars.get(0).setSteps(3);
        cars.get(1).setSteps(3);
        cars.get(2).setSteps(2);
        List<Car> result = Application.checkWinners(cars);
        assertThat(result).hasSize(2);
    }

}