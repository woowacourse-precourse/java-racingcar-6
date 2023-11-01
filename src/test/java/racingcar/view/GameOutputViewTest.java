package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.IOTest;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameOutputViewTest extends IOTest {

    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("자동차 리스트가 주어지고, 주어진 자동차들의 상태를 출력한다.")
    @Test
    void givenCars_whenDisplayCarStatuses_thenDisplayStatuses() {
        List<Car> cars = List.of(
                createCar("test1", 4),
                createCar("test2", 0)
        );

        GameOutputView.displayCurrentCarStatuses(cars);

        assertThat(output()).contains("test1 : ----", "test2 :");
    }

    private Car createCar(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            assertRandomNumberInRangeTest(car::moveForwardRandomly, MOVE_FORWARD, STOP);
        }
        return car;
    }
}