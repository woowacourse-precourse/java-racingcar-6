package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("우승자는 한 명이어야 한다.")
    void findWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("KIA", 1));
        carList.add(new Car("BMW", 0));
        carList.add(new Car("AUDI", 0));

        List<String> names = List.of("KIA", "BMW", "AUDI");
        Cars cars = new Cars(names);
        cars.setCars(carList);
        List<String> result = cars.findWinners();

        assertThat(result).containsExactly("KIA");
    }

    @Test
    @DisplayName("우승자는 두 명이어야 한다.")
    void findWinners() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("KIA", 1));
        carList.add(new Car("BMW", 1));
        carList.add(new Car("AUDI", 0));

        List<String> names = List.of("KIA", "BMW", "AUDI");
        Cars cars = new Cars(names);
        cars.setCars(carList);
        List<String> result = cars.findWinners();

        assertThat(result).containsExactly("KIA", "BMW");
    }
}
