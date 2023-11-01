package racingcar.domain;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.EMPTY_INPUT_ERROR;
import static racingcar.constant.ErrorMessage.LENGTH_INPUT_ERROR;
import static racingcar.constant.RaceSetting.MAX_CAR_NAME_LENGTH;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("자동차 이름 입력을 올바르게 입력한다.")
    void cars() {
        assertDoesNotThrow(() -> new Car("car"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차 이름 중 빈 문자열이 있다면, 예외 처리한다.")
    void car2(String carName) {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Car(carName)
        );
        assertThat(exception.getMessage()).isEqualTo(EMPTY_INPUT_ERROR.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"123456", "1234567"})
    @DisplayName("자동차 이름 중 5자보다 넘는 이름이 있다면, 예외 처리한다.")
    void cars3(String carName) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Car(carName)
        );
        assertThat(exception.getMessage()).isEqualTo(
                format(LENGTH_INPUT_ERROR.getMessage(), MAX_CAR_NAME_LENGTH.getValue())
        );
    }

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