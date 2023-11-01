package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1", 2));
        carList.add(new Car("2", 4));
        carList.add(new Car("3", 3));
        carList.add(new Car("4", 4));
        carList.add(new Car("5", 2));
        cars = new Cars(carList);
    }

    @Test
    void race() {
        cars.race(() -> true);

        List<Integer> forwardCounts = cars.copyList()
                .stream()
                .map(Car::getForwardCount)
                .toList();

        assertThat(forwardCounts).containsExactly(3, 5, 4, 5, 3);
    }

    @Test
    void findWinners() {
        List<String> winners = cars.findWinners();

        assertThat(winners).containsExactly("2", "4");
    }
}
