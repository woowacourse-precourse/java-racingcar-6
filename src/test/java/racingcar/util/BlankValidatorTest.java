package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BlankValidatorTest {
    @Test
    void validateBlank_메서드로_입력_문자열이_공백이_아닌지_검증() {
        String blankString = " ";

        assertTrue(BlankValidator.isBlank(blankString));
    }

}
