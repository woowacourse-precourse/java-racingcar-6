package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.car.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("잘못된 길이의 자동차 이름인 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @NullSource
    @ValueSource(strings = {"myCarIsKia", "myName"})
    void checkValidateLength(String name) {
        assertThatThrownBy(() -> Car.ofStartingPoint(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 타입의 자동차 이름인 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @NullSource
    @ValueSource(strings = {"k!#", "^w^", ",,", ",,,"})
    void checkValidateType(String name) {
        assertThatThrownBy(() -> Car.ofStartingPoint(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 공백인 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @NullSource
    @ValueSource(strings = {"", "  ", "      "})
    void checkValidateSpace(String name) {
        assertThatThrownBy(() -> Car.ofStartingPoint(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 자동차 이름 테스트")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @ValueSource(strings = {"soul", "bb", "k", "동 글"})
    void checkCorrectName(String name) {
        Car car = Car.ofStartingPoint(name);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }
}
