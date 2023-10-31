package racingcar.domain;


import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.*;
import static racingcar.constant.RaceSetting.MAX_CAR_NAME_LENGTH;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    @Test
    @DisplayName("자동차 이름 입력을 올바르게 입력한다.")
    void cars() {
        List<String> carNameInput = List.of("car1", "car2", "car3", "car4!");
        Cars cars = new Cars(carNameInput);
        assertThat(cars.getCars())
                .extracting(Car::getName)
                .containsExactly("car1", "car2", "car3", "car4!");
    }

    @ParameterizedTest
    @CsvSource({"'', car1, car2", "' ', car1, car2", "car1, car2, ''"})
    @DisplayName("자동차 이름 중 빈 문자열이 있다면, 예외 처리한다.")
    void cars2(String carName1, String carName2, String carName3) {
        List<String> carNameInput = List.of(carName1, carName2, carName3);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cars(carNameInput)
        );
        assertThat(exception.getMessage()).isEqualTo(EMPTY_INPUT_ERROR.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"123456, car1, car2", "car1, 123456, car2", "car1, car2, 123456"})
    @DisplayName("자동차 이름 중 5자보다 넘는 이름이 있다면, 예외 처리한다.")
    void cars3(String carName1, String carName2, String carName3) {
        List<String> carNameInput = List.of(carName1, carName2, carName3);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cars(carNameInput)
        );
        assertThat(exception.getMessage()).isEqualTo(
                format(LENGTH_INPUT_ERROR.getMessage(), MAX_CAR_NAME_LENGTH.getValue())
        );
    }

    @ParameterizedTest
    @CsvSource({"car1, car1, car2", "car1, car2, car1", "car1, car2, car2"})
    @DisplayName("자동차 이름 중 중복되는 이름이 있다면, 예외 처리한다.")
    void cars4(String carName1, String carName2, String carName3) {
        List<String> carNameInput = List.of(carName1, carName2, carName3);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Cars(carNameInput)
        );

        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_INPUT_ERROR.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 0, 0, 0", "2, 3, 4, 0, 0, 1", "3, 4, 5, 0, 1, 1"})
    @DisplayName("run 메서드를 통해 자동차의 무작위 값으로 자동차를 전진, 정지한다.")
    void run(Integer number1, Integer number2, Integer number3,
             Integer distance1, Integer distance2, Integer distance3) {
        List<String> carNameInput = List.of("car1", "car2", "car3");
        Cars cars = new Cars(carNameInput);
        List<Integer> numbers = List.of(number1, number2, number3);
        cars.run(new TestNumberGenerator(numbers));
        assertThat(cars.getCars())
                .extracting(Car::getDistance)
                .containsExactly(distance1, distance2, distance3);
    }
}