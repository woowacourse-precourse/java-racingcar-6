package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    private String carNames = ",june,joo,weeyoungseok,june";
    private CarNameValidator carNameValidator = new CarNameValidator(this.carNames);

    @Test
    void 처음_자동차_이름_쉽표_입력값_null_예외() {
        String carNames = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringValidator.stringIsNull(carNames);
        });
    }

    @Test
    void 처음_자동차_이름_쉽표_입력값_blank_예외() {
        String carNames = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringValidator.stringIsBlank(carNames);
        });
    }

    @Test
    void 자동차_이름중_blank_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateBlank();;
        });
    }

    @Test
    void 자동차_이름중_5자_초과_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateLength();;
        });
    }

    @Test
    void 자동차_이름중_중복_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateDuplicate();;
        });
    }
}
