package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class InputValidatorTest {

    @DisplayName("")
    @Test
    void test() {
        // given
        final String input1 = "a,b,c";
        final String input2 = "a,b";
        final InputValidator inputValidator = new InputValidator();
        // when
        // then
        inputValidator.validateCarNamesInput(input1);
        inputValidator.validateCarNamesInput(input2);
    }
}