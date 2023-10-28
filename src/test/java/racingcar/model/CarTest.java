package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성")
    void of() {
        Car car = Car.of("pobi");

        assertThat(car).isEqualTo(Car.of("pobi"));
    }

    @ParameterizedTest
    @CsvSource({"4", "9"})
    @DisplayName("자동차 이동 - 4 이상")
    void move(int randomNumber) {
        Car car = Car.of("pobi");
        car = car.move(() -> randomNumber);

        assertThat(car).isEqualTo(Car.ofWithPosition("pobi", 1));
    }

    @ParameterizedTest
    @CsvSource({"3", "0"})
    @DisplayName("자동차 이동 - 3 이하")
    void moveFail(int randomNumber) {
        Car car = Car.of("pobi");
        car = car.move(() -> randomNumber);

        assertThat(car).isEqualTo(Car.ofWithPosition("pobi", 0));
    }
}