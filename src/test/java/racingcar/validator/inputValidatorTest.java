package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class inputValidatorTest {

    private InputValidator inputValidator = new InputValidator();
    @Test
    void 자동차_이름들이_정상적으로_입력() {
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,woni,jun"));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,lee dohyun,apple"));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi lee,lee do hyun,apple"));
    }

    @Test
    void 자동차_이름들이_비정상적으로_입력되어_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobi, apple,jun"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobi&apple&jun"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobi,apple,한글이름"));
    }
}