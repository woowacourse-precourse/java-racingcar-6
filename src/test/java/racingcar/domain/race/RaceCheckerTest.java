package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCheckerTest {
    @Test
    @DisplayName("RaceChecker는 자동차의 리스트를 받아서 우승자를 알려준다")
    void get_winner_test() {
        // given
        List<Car> cars = createCarsWithPosition(2, 3, 4);

        // when
        RaceChecker checker = new RaceChecker();
        RaceResult result = checker.checkWinner(cars);

        // then
        assertThat(result.winners()).containsExactly(cars.get(2));
    }

    @Test
    @DisplayName("우승자는 여러 명일 경우도 있다")
    void get_winner_several_test() {
        // given
        List<Car> cars = createCarsWithPosition(2, 3, 3);

        // when
        RaceChecker checker = new RaceChecker();
        RaceResult result = checker.checkWinner(cars);

        // then
        assertThat(result.winners()).containsExactly(cars.get(1), cars.get(2));
    }

    private List<Car> createCarsWithPosition(int... positions) {
        List<Car> cars = new ArrayList<>();

        for (int position : positions) {
            Car car = new Car("car", () -> true);
            moveCar(car, position);

            cars.add(car);
        }

        return cars;
    }

    private void moveCar(Car car, int count) {
        for (int i = 0; i < count; ++i) {
            car.move();
        }
    }
}
