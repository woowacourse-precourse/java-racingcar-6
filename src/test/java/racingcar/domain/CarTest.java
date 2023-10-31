package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "5, 1", "6, 1"})
    @DisplayName("run 메서드는 입력값이 4 이상인 경우, 전진한다.")
    void run(int number, int distance) {
        Car car = new Car("ABC");
        car.run(number);
        assertThat(car.getDistance()).isEqualTo(distance);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 0", "3, 0"})
    @DisplayName("run 메서드는 입력값이 4 미만인 경우, 정지한다.")
    void run2(int number, int distance) {
        Car car = new Car("ABC");
        car.run(number);
        assertThat(car.getDistance()).isEqualTo(distance);
    }
}