package util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.CarNameValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarNameValidatorTests {
    private final CarNameValidator validator = new CarNameValidatorImpl();

    @Test
    @DisplayName("입력값이 5글자를 초과한 경우 false 를 반환해야 한다")
    void test1() {
        // given
        String input = "5글자넘는이름";

        // when
        boolean result = validator.validate(input);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("입력값이 5글자 이하인 경우 true 를 반환해야 한다")
    void test2() {
        // given
        String input = "5글자이름";

        // when
        boolean result = validator.validate(input);

        // then
        assertTrue(result);
    }
}
