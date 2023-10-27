package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarValidatorTest {

    //TODO: 괜찮은 형태이니? DI 고민해보자
    private final CarValidator carValidator = new CarValidator();

    @DisplayName("클래스 지원 테스트")
    @Test
    void checkSupport() {
        assertThat(carValidator.support(Car.class)).isTrue();
    }
}