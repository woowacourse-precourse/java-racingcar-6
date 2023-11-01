package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("올바른 자동차 이름")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @ValueSource(strings = {"soul", "bb", "k", "동 글"})
    void checkCorrectName(String name) {
        Car car = Car.ofStartingPoint(name);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }
}
