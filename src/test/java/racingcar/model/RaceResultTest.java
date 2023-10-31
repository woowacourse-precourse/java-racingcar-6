package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.service.MovementStrategy;
import racingcar.service.MovementStrategyFactory;

class RaceResultTest {
    private MovementStrategy movementStrategy;

    @BeforeEach
    void setUp() {
        movementStrategy = MovementStrategyFactory.createDefault();
    }

    @Test
    void 모든_자동차_거리가_다른_경우_winner() {
        List<Car> carList = createCars(1, 2, 3);
        assertWinners(carList, Arrays.asList("c"));
    }

    @Test
    void 모든_자동차_거리가_같은_경우_winner() {
        List<Car> carList = createCars(1, 1, 1);
        assertWinners(carList, Arrays.asList("a", "b", "c"));
    }

    @Test
    void 일부_자동차_거리가_같은_경우_winner() {
        List<Car> carList = createCars(3, 1, 3);
        assertWinners(carList, Arrays.asList("a", "c"));
    }

    @Test
    void 일부_자동차_거리가_같은_경우_winner2() {
        List<Car> carList = createCars(3, 1, 1);
        assertWinners(carList, Arrays.asList("a"));
    }

    private List<Car> createCars(int... distances) {
        String[] names = {"a", "b", "c"};
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < distances.length; i++) {
            carList.add(new Car(names[i], distances[i], movementStrategy));
        }
        return carList;
    }

    private void assertWinners(List<Car> carList, List<String> expected) {
        Cars cars = new Cars(carList);
        RaceResult raceResult = new RaceResult(cars);
        List<String> result = raceResult.getWinners();
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}