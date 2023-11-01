package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RaceTest {

    @Test
    void 음수의_경주_횟수_생성시_예외_반환() {
        String[] names = {"pobi", "yen"};
        String time = "-1";

        assertThatThrownBy(() -> new Race(names, time))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열인_경주_횟수_생성시_예외_반환() {
        String[] names = {"pobi", "yen"};
        String time = "asdf";

        assertThatThrownBy(() -> new Race(names, time))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한_라운드_실행_후_결과_만들기() {
        String[] names = {"pobi", "yen"};
        int idx = 1;
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, idx++));
        }
        Race race = new Race(cars, 3);
        String result = race.getResult();

        assertThat(result).isEqualTo("pobi : -\nyen : --\n");
    }

    @Test
    void 단독_우승자_구하기() {
        String[] names = {"pobi", "yen"};
        int idx = 1;
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, idx++));
        }
        Race race = new Race(cars, 3);
        String winner = race.getWinners();

        assertThat(winner).isEqualTo("yen");
    }

    @Test
    void 공동_우승자_구하기() {
        String[] names = {"pobi", "yen"};
        int idx = 1;
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, idx));
        }
        Race race = new Race(cars, 3);
        String winners = race.getWinners();

        assertThat(winners).isEqualTo("pobi, yen");
    }
}
