package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.car.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @DisplayName("자동차 이름의 길이가 잘못된 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @ValueSource(strings = {"myCarIsKia", "myName", " "})
    void checkValidateLength(String name){
        assertThatThrownBy(() -> Car.ofStartPoint(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
