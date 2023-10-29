package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarNameValidator;
import racingcar.util.BlankValidator;

public class CarNameValidatorTest {
    BlankValidator blankValidator = new BlankValidator();
    CarNameValidator carNameValidator = new CarNameValidator(blankValidator);

    @DisplayName("자동차이동름입력 - 정상입력")
    @Test
    void checkNormalCarNmaeInput() {
        String carName = "hong,kim,jun";
        assertDoesNotThrow(() -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - 5자 초과입력시 예외발생")
    @Test
    void checklCarNmaeInputOverSize() {
        String carName = "hosdfsdng,kim,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - 중복된 이름입력시 예외발생")
    @Test
    void checklCarNmaeInputDuplicate() {
        String carName = "kim,kim,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }


}
