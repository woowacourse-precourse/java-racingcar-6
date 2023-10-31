package racingcar.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class RaceTest {

    @Test
    void 경주_움직임_테스트() {
        List<Car> cars = Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
        Race race = new Race(cars);
        race.race();
        boolean anyCarMoved = cars.stream().anyMatch(car -> car.getPosition() > 0);
        assertThat(anyCarMoved).isTrue();
    }

    @Test
    void 초기_경주_상태_테스트() {
        List<Car> cars = Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
        boolean allCarsAtStartPosition = cars.stream().allMatch(car -> car.getPosition() == 0);
        assertThat(allCarsAtStartPosition).isTrue();
    }

    @Test
    void 우승자_테스트() {
        List<Car> cars = Arrays.asList(new Car("A"), new Car("B"), new Car("C"));
        Race race = new Race(cars);
        Car expectedWinner = cars.get(0);
        for (int i = 0; i < 3; i++) { // A를 3번 앞으로 움직임
            expectedWinner.tryMove();
        }

        List<Car> winners = race.getWinners();
        assertThat(winners).containsExactly(expectedWinner);
    }

}
