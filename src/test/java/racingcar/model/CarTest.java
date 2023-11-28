package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.car.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @DisplayName("자동차 이름의 길이가 잘못된 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @ValueSource(strings = {"soul", "bb", "안 녕"})
    void checkValidateLength(String name){
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
