package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void blank_입력값이_빈_문자열_혹은_공백이_아닌_유효한_경우() {
        String input = "This string is not blank";

        Assertions.assertDoesNotThrow(() -> InputValidator.blank(input));
    }

    @Test
    void blank_입력값이_공백_으로만_이루어진_경우_예외_발생() {
        String input = "        ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidator.blank(input));
    }

    @Test
    void blank_입력값이_빈_문자열인_경우_예외_발생() {
        String input = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidator.blank(input));
    }
}
