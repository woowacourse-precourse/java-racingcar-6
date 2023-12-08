package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarValidatorTest {
//    private final CarValidator carValidator = new CarValidator();

    @DisplayName("클래스 지원 테스트")
    @Test
    void checkSupport() {
        Validator carValidator = new CarValidator();
        assertThat(carValidator.support(Car.class)).isTrue();
    }
}
