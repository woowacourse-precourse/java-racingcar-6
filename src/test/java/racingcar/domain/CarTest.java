package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("전진")
    @ParameterizedTest
    @CsvSource({"4,1", "3,0", "9,1"})
    void move(int randomNumber, int position) {

        Car car = new Car("testCar");

        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(position);

    }
}