package util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.util.validator.proxy.InputValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static racingcar.container.ApplicationContainer.getInputValidator;

public class InputValidatorTests {
    private final InputValidator validator = getInputValidator();

    @Test
    @DisplayName("입력값이 5글자를 초과한 경우 false 반환")
    void test1() {
        // given
        String input = "5글자넘는이름";

        // when
        boolean result = validator.validateName(input);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("입력값이 5글자 이하인 경우 true 반환")
    void test2() {
        // given
        String input = "5글자이름";

        // when
        boolean result = validator.validateName(input);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 false 반환")
    void test3() {
        // given
        String input = "A1f";

        // when
        boolean result = validator.validateRaceCount(input);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("입력값이 음수인 경우 false 반환")
    void test4() {
        // given
        String input = "-1";

        // when
        boolean result = validator.validateRaceCount(input);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("입력값이 0 이상의 숫자인 경우 true 반환")
    void test5() {
        // given
        String input = "912";

        // when
        boolean result = validator.validateRaceCount(input);

        // then
        assertTrue(result);
    }
}
