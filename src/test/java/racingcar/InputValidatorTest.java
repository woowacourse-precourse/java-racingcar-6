package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.global.exception.ErrorMessage.EMPTY_VALUE;
import static racingcar.global.exception.ErrorMessage.INVALID_INPUT;
import static racingcar.global.exception.ErrorMessage.INVALID_LENGTH;
import static racingcar.global.exception.ErrorMessage.NOT_A_NUMBER;
import static racingcar.validate.InputValidator.validateEmptyInput;
import static racingcar.validate.InputValidator.validateInput;
import static racingcar.validate.InputValidator.validateNameLength;
import static racingcar.validate.InputValidator.validateNumberInput;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.global.exception.CarGameException;

public class InputValidatorTest {
    @Test
    void validateEmptyInput_메서드_사용시_빈_문자열이_주어진_경우_예외_발생() {
        String testCase = "";

        assertThatThrownBy(() -> validateEmptyInput(testCase))
                .isInstanceOf(CarGameException.class)
                .hasMessageContaining(EMPTY_VALUE.getMessage());
    }

    @Test
    void validateInput_메서드_사용시_패턴에_맞지_않는_경우_예외_발생() {
        List<String> testCases = List.of("!!!---", "   ");

        testCases.forEach(testCase ->
                assertThatThrownBy(() -> validateInput(testCase))
                        .isInstanceOf(CarGameException.class)
                        .hasMessageContaining(INVALID_INPUT.getMessage()));
    }

    @Test
    void validateNumberInput_메서드_사용시_숫자가_아닌_경우_예외_발생() {
        List<String> testCases = List.of("1a23", "aaa", "  bb");

        testCases.forEach(testCase ->
                assertThatThrownBy(() -> validateNumberInput(testCase))
                        .isInstanceOf(CarGameException.class)
                        .hasMessageContaining(NOT_A_NUMBER.getMessage()));
    }

    @Test
    void validateNameLength_메서드_사용시_길이_초과_이름인_경우_예외_발생() {
        List<String> testCases = List.of("minjaePark", "minjaeJuu", "minjaeGIII");

        testCases.forEach(testCase ->
                assertThatThrownBy(() -> validateNameLength(testCase))
                        .isInstanceOf(CarGameException.class)
                        .hasMessageContaining(INVALID_LENGTH.getMessage()));
    }
}
