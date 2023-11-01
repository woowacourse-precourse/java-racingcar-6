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
}
