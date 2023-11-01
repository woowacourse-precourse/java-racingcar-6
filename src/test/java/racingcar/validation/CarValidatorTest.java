package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.car.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarValidatorTest {

    @DisplayName("Car 클래스 지원")
    @Test
    void checkSupport() {
        Validator carValidator = new CarValidator();
        assertThat(carValidator.support(Car.class)).isTrue();
    }

    @DisplayName("잘못된 길이의 자동차 이름인 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @NullSource
    @ValueSource(strings = {"myCarIsKia", "myName"})
    void checkValidateLength(String name) {
        Validator validator = new CarValidator();
        assertThatThrownBy(() -> validator.validate(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 타입의 자동차 이름인 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @NullSource
    @ValueSource(strings = {"k!#", "^w^", ",,", ",,,"})
    void checkValidateType(String name) {
        Validator validator = new CarValidator();
        assertThatThrownBy(() -> validator.validate(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 공백인 경우 예외 발생")
    @ParameterizedTest(name = "{displayName} value = {0}")
    @NullSource
    @ValueSource(strings = {"", "  ", "      "})
    void checkValidateSpace(String name) {
        Validator validator = new CarValidator();
        assertThatThrownBy(() -> validator.validate(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
