package util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.validator.RaceCountValidator;
import racingcar.util.validator.RaceCountValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceCountValidatorTests {
    private final RaceCountValidator validator = new RaceCountValidatorImpl();

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 false 를 반환해야 한다")
    void test1() {
        // given
        String input = "A1f";

        // when
        boolean result = validator.validate(input);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("입력값이 음수인 경우 false 를 반환해야 한다")
    void test2() {
        // given
        String input = "-1";

        // when
        boolean result = validator.validate(input);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("입력값이 0 이상의 숫자인 경우 true 를 반환해야 한다")
    void test3() {
        // given
        String input = "912";

        // when
        boolean result = validator.validate(input);

        // then
        assertTrue(result);
    }
}
