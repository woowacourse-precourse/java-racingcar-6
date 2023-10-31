package racingcar.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.exception.RoundCountInvalidException;

class RoundCountValidatorTest {

    private static final String NOT_NUMBER = "1ab";
    private static final String NOT_INTEGER = "123.4";
    private static final String ZERO = "0";
    private static final String NEGATIVE_INTEGER = "-1";

    @Test
    void 숫자가_아닐_경우_예외_발생() {
        assertThrows(RoundCountInvalidException.class,
                () -> RoundCountValidator.validate(NOT_NUMBER));
    }

    @Test
    void 정수가_아닐_경우_예외_발생() {
        assertThrows(RoundCountInvalidException.class,
                () -> RoundCountValidator.validate(NOT_INTEGER));
    }

    @Test
    void 입력이_0일_경우_예외_발생() {
        assertThrows(RoundCountInvalidException.class,
                () -> RoundCountValidator.validate(ZERO));
    }

    @Test
    void 입력이_음수일_경우_예외_발생() {
        assertThrows(RoundCountInvalidException.class,
                () -> RoundCountValidator.validate(NEGATIVE_INTEGER));
    }
}