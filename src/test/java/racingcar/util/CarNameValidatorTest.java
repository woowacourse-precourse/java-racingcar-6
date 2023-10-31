package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    private CarNameValidator carNameValidator;

    @BeforeEach
    void init(){
        carNameValidator = new CarNameValidator();
    }

    @Test
    @DisplayName("입력한 자동차 이름의 길이가 5자보다 클 경우 예외가 발생한다.")
    void TestCarNameLength(){
        String carNames = "car1,car2,car345";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    @DisplayName("입력한 자동차 이름이 중복될 경우 예외가 발생한다.")
    void TestCarNameDuplicate(){
        String carNames = "car1,car2,car2";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameValidator.validateCarNames(carNames));
    }

}
