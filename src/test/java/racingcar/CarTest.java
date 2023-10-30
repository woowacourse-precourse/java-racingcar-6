package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import racingcar.car.Car;

class CarTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/car-names.csv", numLinesToSkip = 1)
    void 이름_길이_제한_성공(String name, Integer lengthLimit) {
        Car car = new Car(name, lengthLimit);
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/car-bad-names.csv", numLinesToSkip = 1)
    void 이름_길이_제한_예외확인(String name, Integer lengthLimit) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(name, lengthLimit);
        });
    }

}
