package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;

public class WinnerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("우승자가 1명만 있는 경우 리스트에는 한 명만 있다.")
    @Test
    void getSingleWinnerTest() {
        assertRandomNumberInRangeTest(
            () -> {
                Car car1 = new Car(new CarName("car1"));
                Car car2 = new Car(new CarName("car2"));
                Car car3 = new Car(new CarName("car3"));
                Cars cars = new Cars(List.of(car1, car2, car3));

                cars.commandAllCarsToMove();
                List<Car> winner = cars.getWinnerList();

                assertThat(winner).containsExactly(car1);
            }, MOVING_FORWARD, STOP, STOP
        );
    }

    @DisplayName("우승자가 2명이 있는 경우 리스트에는 2명만 있다.")
    @Test
    void getDoubleWinnerTest() {
        assertRandomNumberInRangeTest(
            () -> {
                Car car1 = new Car(new CarName("car1"));
                Car car2 = new Car(new CarName("car2"));
                Car car3 = new Car(new CarName("car3"));
                Cars cars = new Cars(List.of(car1, car2, car3));

                cars.commandAllCarsToMove();
                List<Car> winner = cars.getWinnerList();

                assertThat(winner).containsExactly(car1, car2);
            }, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("우승자가 3명이 있는 경우 리스트에는 3명만 있다.")
    @Test
    void getTripleWinnerTest() {
        assertRandomNumberInRangeTest(
            () -> {
                Car car1 = new Car(new CarName("car1"));
                Car car2 = new Car(new CarName("car2"));
                Car car3 = new Car(new CarName("car3"));
                Cars cars = new Cars(List.of(car1, car2, car3));

                cars.commandAllCarsToMove();
                List<Car> winner = cars.getWinnerList();

                assertThat(winner).containsExactly(car1, car2, car3);
            }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
