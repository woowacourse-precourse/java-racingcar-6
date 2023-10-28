package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class inputValidatorTest {

    private InputValidator inputValidator = new InputValidator();
    @Test
    void 자동차_이름들이_정상적으로_입력() {
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,woni,jun"));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,lee d,apple"));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputCarName("pobi,lee,apple"));
    }

    @Test
    void 자동차_이름들이_비정상적으로_입력되어_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobi, apple"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobi&apple&jun"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("한글이름"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputCarName("pobiii"));
    }

    @Test
    void 시도_횟수_입력에_숫자만_포함() {
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputTryCount("123"));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputTryCount("103"));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputTryCount("1"));
    }

    @Test
    void 시도_횟수_입력_예외처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount(" 123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount("0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputTryCount("012"));
    }
}