package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarInputValidatorTest {

    @Test
    void 이름_중복_확인() {
        String[] cars = new String[]{"yong", "soo", "soo"};

        assertThatThrownBy(() -> CarInputValidator.validateCars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력_확인() {
        String[] cars = new String[]{};

        assertThatThrownBy(() -> CarInputValidator.validateCars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_확인() {
        String car = "yongsoo";
        assertThatThrownBy(() -> CarInputValidator.validateCar(car))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_공백_확인() {
        String car = "";
        assertThatThrownBy(() -> CarInputValidator.validateCar(car))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
