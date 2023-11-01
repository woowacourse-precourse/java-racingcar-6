package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void 레이스_초기화() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars);
        assertThat(race).isNotNull();
    }

    @Test
    void 레이스_실행() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars);
        race.run();
        assertThat(race.getCars()).isNotEmpty();
    }
}
