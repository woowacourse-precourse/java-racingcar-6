package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RaceTest {
    @Test
    void 단독_우승자_구하기() {
        int move = 1;
        String[] names = {"pobi", "yen"};
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, move++));
        }
        Race race = new Race(cars, 3);

        List<String> result = race.getWinners();

        assertThat(result).hasSize(1);
        assertThat(result).containsExactly("yen");

    }

    @Test
    void 공동_우승자_구하기() {
        int move = 1;
        String[] names = {"pobi", "yen"};
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, move++));
        }
        cars.add(new Car("red", 2));
        Race race = new Race(cars, 3);

        List<String> result = race.getWinners();

        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("yen", "red");

    }
}
