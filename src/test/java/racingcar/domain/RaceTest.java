package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class RaceTest {

    @Test
    void 주어진_횟수동안_자동차는_전진하거나_멈춘다() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars);
        race.run(5); // 5번 움직임
        for (Car car : cars) {
            assertThat(car.getPosition()).isBetween(0, 5);
        }
    }

    @Test
    void 승자_결정() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars);
        race.run(5); // 5번 움직임
        List<String> winners = race.getWinners();
        assertThat(winners).isNotEmpty();
    }

}
