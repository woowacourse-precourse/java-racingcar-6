package racingcar.domain.winner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.racing.MoveStrategy;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCheckerTest {

    @Test
    @DisplayName("가장 먼 거리를 이동한 자동차를 승리자로 정확히 찾아야 한다")
    void findWinners_CarsWithDifferentPositions_CorrectWinnersFound() {
        // Given
        MoveStrategy moveStrategy = () -> true; // 항상 전진하는 전략
        Car car1 = new Car("car1", moveStrategy);
        Car car2 = new Car("car2", moveStrategy);
        Car car3 = new Car("car3", moveStrategy);

        car1.move(); // position = 1
        car2.move(); // position = 1
        car2.move(); // position = 2
        car3.move(); // position = 1

        List<Car> cars = Arrays.asList(car1, car2, car3);
        WinnerChecker winnerChecker = new WinnerChecker(cars);

        // When
        List<String> winners = winnerChecker.findWinners();

        // Then
        assertThat(winners).containsExactly("car2");
    }

    @Test
    @DisplayName("모든 자동차가 같은 거리를 이동했다면 모든 자동차가 승리자가 되어야 한다")
    void findWinners_CarsWithSamePositions_AllCarsAreWinners() {
        // Given
        MoveStrategy moveStrategy = () -> true; // 항상 전진하는 전략
        Car car1 = new Car("car1", moveStrategy);
        Car car2 = new Car("car2", moveStrategy);
        Car car3 = new Car("car3", moveStrategy);

        car1.move(); // position = 1
        car2.move(); // position = 1
        car3.move(); // position = 1

        List<Car> cars = Arrays.asList(car1, car2, car3);
        WinnerChecker winnerChecker = new WinnerChecker(cars);

        // When
        List<String> winners = winnerChecker.findWinners();

        // Then
        assertThat(winners).containsExactlyInAnyOrder("car1", "car2", "car3");
    }
}
