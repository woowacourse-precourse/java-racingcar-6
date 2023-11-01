package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class InputValidatorTest {
    @Test
    void 자동차_이름의_길이_초과에_대한_예외_처리() {

        List<String> carNames = Arrays.asList("Car1", "Car2", "Car345678");

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNameLength(carNames));
    }

    @Test
    void testInsufficientPlayers() {

        List<String> carNames = Collections.singletonList("Car1");

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNameLength(carNames));
    }

    @Test
    public void 시도_횟수의_공백_입력에_대한_예외_처리() {

        String emptyString = "";

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumberType(emptyString));
    }

    @Test
    public void 시도_횟수_입력에_숫자가_아닌_다른_문자_입력에_대한_예외_처리() {

        String invalidNumber = "abc";

        assertThrows(NumberFormatException.class, () -> InputValidator.validateTryNumberType(invalidNumber));
    }
}
