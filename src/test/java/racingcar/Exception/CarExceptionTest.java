package racingcar.Exception;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarExceptionTest {

    @ParameterizedTest
    @DisplayName("유효한 자동차 이름은 예외를 발생시키지 않아야 합니다.")
    @ValueSource(strings = {"jumpk,jney,pobi,neo", "car1,car2,car3,car4,car5"})
    void givenValidCarNames_shouldNotThrowExceptions(String carNames) {
        CarException carException = new CarException();

        assertThatCode(() -> carException.checkExceptionCar(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 자동차 이름은 예외를 발생시켜야 합니다.")
    @ValueSource(strings = {",", "car1, ,car3,car4", "car1,,car3,car4", "car1,car2,car343", "only1", " ", "",
            "car 1,car2",
            "car1, car2", "car1,car1,car2"})
    void givenInvalidCarNames_shouldThrowExceptions(String carNames) {
        CarException carException = new CarException();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carException.checkExceptionCar(carNames));
    }

}