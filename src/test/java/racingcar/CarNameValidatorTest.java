package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarNameValidator;
import racingcar.util.BlankValidator;

public class CarNameValidatorTest {
    BlankValidator blankValidator = new BlankValidator();

    @DisplayName("자동차이동름입력 - 정상입력")
    @Test
    void checkNormalCarNmaeInput(){
        String carName = "hong,kim,jun";
        CarNameValidator carNameValidator = new CarNameValidator(blankValidator);
        assertDoesNotThrow(() -> carNameValidator.processCarNames(carName));
    }
}
