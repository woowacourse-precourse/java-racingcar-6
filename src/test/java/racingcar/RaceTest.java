package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.Car;
import racingcar.race.Race;

class RaceTest {
    private List<Car> cars = Arrays.asList(new Car("kim"), new Car("mi"));
    Race race = new Race(cars, 3);

    @Test
    @DisplayName("경주게임 인스턴스 생성확인")
    void Race_인스턴스_생성확인() {
        List<Car> car = new ArrayList<Car>();
        int tryCount = 0;
        Race race = new Race(car, tryCount);
    }

    @Test
    @DisplayName("경주 시 전진에 대한 동작확인")
    void startRace_동작확인_전진() {
        race.getMoveStatus().setTestMoveStatus(true);
        race.startRace();

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(3);
        }
    }

    @Test
    @DisplayName("경주 시 정지에 대한 동작확인")
    void startRace_동작확인_정지() {
        race.getMoveStatus().setTestMoveStatus(false);
        race.startRace();

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("우승자 가져오기에 대한 동작확인")
    void getWinners_동작확인() {
        race.getMoveStatus().setTestMoveStatus(true);
        cars.get(0).move(race.getMoveStatus());
        List<Car> winners = race.getWinners();
        assertThat(winners).contains(cars.get(0));
    }

    @Test
    @DisplayName("공동우승자 가져오기에 대한 동작확인")
    void getWinners_공동우승_동작확인() {
        race.getMoveStatus().setTestMoveStatus(true);
        cars.get(0).move(race.getMoveStatus());
        cars.get(1).move(race.getMoveStatus());
        List<Car> winners = race.getWinners();
        assertThat(winners).contains(cars.get(0));
        assertThat(winners).contains(cars.get(1));
    }
}