package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void makeCarsByNamesWithNoNames() {
        String[] carNames = {};
        Assertions.assertThatThrownBy(() -> Cars.makeCarsByNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void tryCars() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        Cars cars = Cars.makeCarsByNames(carNames);

        // 모든 차량을 한 번씩 전진시키는 동작 테스트
        cars.tryCars();
    }

    @Test
    void findWinner() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        Cars cars = Cars.makeCarsByNames(carNames);

        String actual = cars.findWinner();
        String expected = "Car1, Car2, Car3";
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}