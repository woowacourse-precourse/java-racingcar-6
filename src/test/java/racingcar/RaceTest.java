package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("kim"), new Car("mi"));
    }
    @Test
    void Race_인스턴스_생성확인() {
        List<Car> car = new ArrayList<Car>();
        int tryCount = 0;
        Race race = new Race(car, tryCount);
    }

    @Test
    void startRace_동작확인_전진() {
        Race race = new Race(cars, 3);
        race.getMoveStatus().setTestMoveStatus(true);
        race.startRace(new ResultView(cars));

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(3);
        }
    }

    @Test
    void startRace_동작확인_정지() {
        Race race = new Race(cars, 3);
        race.getMoveStatus().setTestMoveStatus(false);
        race.startRace(new ResultView(cars));

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    void getWinners_동작확인() {
        Race race = new Race(cars, 3);
        race.getMoveStatus().setTestMoveStatus(true);
        cars.get(0).move(race.getMoveStatus());
        List<Car> winners = race.getWinners();
        assertThat(winners).contains(cars.get(0));
    }

    @Test
    void getWinners_공동우승_동작확인() {
        Race race = new Race(cars, 3);
        race.getMoveStatus().setTestMoveStatus(true);
        cars.get(0).move(race.getMoveStatus());
        cars.get(1).move(race.getMoveStatus());
        List<Car> winners = race.getWinners();
        assertThat(winners).contains(cars.get(0));
        assertThat(winners).contains(cars.get(1));
    }
}