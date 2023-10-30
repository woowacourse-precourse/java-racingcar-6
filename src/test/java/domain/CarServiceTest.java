package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    @Test
    void 전진_조건이_정상적으로_반영되는가() {
        CarService carService = new CarService();

        assertFalse(carService.decideGo(0));
        assertFalse(carService.decideGo(3));
        assertTrue(carService.decideGo(4));
        assertTrue(carService.decideGo(9));
    }

    @Test
    void 최종_우승자를_판단할_수_있는가() {
        List<Car> cars = List.of(
                new Car("pobi", 1),
                new Car("woni", 2),
                new Car("jun", 3)
        );
        CarService carService = new CarService(cars);
        List<String> winnersNames = carService.decideWinner().stream()
                .map(Car::getName)
                .toList();
        assertThat(winnersNames).isEqualTo(List.of("jun"));

        cars = List.of(
                new Car("pobi", 2),
                new Car("woni", 2),
                new Car("jun", 1)
        );
        carService = new CarService(cars);
        winnersNames = carService.decideWinner().stream()
                .map(Car::getName)
                .toList();
        assertThat(winnersNames).isEqualTo(List.of("pobi", "woni"));
    }
}
