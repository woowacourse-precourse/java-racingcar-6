package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;

public class RaceTest {
    private Race race;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(
                new Car("Car1"),
                new Car("Car2"),
                new Car("Car3")
        );
        MoveStrategy moveStrategy = new RandomGenerator();
        race = new Race(cars, 5, moveStrategy);
    }

    @Test
    void 주어진_횟수_안에_자동차_위치_존재_검증() {
        race.run();
        for (Car car : cars) {
            assertThat(car.getPosition()).isBetween(0, 5);
        }
    }

    @Test
    void 단일_우승자_선택_검증() {
        cars.get(0).move(() -> true);
        cars.get(1).move(() -> false);
        cars.get(2).move(() -> false);

        List<Car> winners = race.getWinners();
        assertThat(winners).containsExactly(cars.get(0));
    }

    @Test
    void 복수_우승자_선택_검증() {
        cars.get(0).move(() -> true);
        cars.get(1).move(() -> true);
        cars.get(2).move(() -> false);

        List<Car> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder(cars.get(0), cars.get(1));
    }
}
