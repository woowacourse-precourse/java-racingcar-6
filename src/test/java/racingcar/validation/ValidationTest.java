package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validation.CarNames.BLANK_INPUT_EXCEPTION;
import static racingcar.validation.CarNames.NAME_LENGTH_EXCEPTION;
import static racingcar.validation.CarNames.SAME_NAMES_EXCEPTION;
import static racingcar.validation.ExecutionNumber.NOT_A_NUMBER_EXCEPTION;
import static racingcar.validation.ExecutionNumber.NUMBER_RANGE_EXCEPTION;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private CarNames carNames = new CarNames();

    @Test
    void 이름이_공백으로만_이루어진_경우_예외처리() {
        List<String> inputs = Arrays.asList("", " ", "    ,  ", ",,,,");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> carNames.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BLANK_INPUT_EXCEPTION);
        });
    }

    @Test
    void 이름_길이가_5이하가_아닌_경우_예외처리() {
        List<String> inputs = Arrays.asList("12, 01-, 123210", "pobi,pororo,crong", "ham bur ger");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> carNames.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NAME_LENGTH_EXCEPTION);
        });
    }

    @Test
    void 같은_이름이_들어온_경우_예외처리() {
        List<String> inputs = Arrays.asList("a,a,a", "pobi,crong,pobi", "*,!,!");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> carNames.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(SAME_NAMES_EXCEPTION);
        });
    }


    private ExecutionNumber number = new ExecutionNumber();

    @Test
    void 시도횟수가_숫자가_아닌경우_예외처리() {
        List<String> inputs = Arrays.asList("", "$@", "abc", "  ");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> number.validateExcutionNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_A_NUMBER_EXCEPTION);
        });
    }

    @Test
    void 시도횟수의_숫자_범위가_잘못된_경우_예외처리() {
        List<String> inputs = Arrays.asList("0", "-12");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> number.validateExcutionNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_RANGE_EXCEPTION);
        });
    }
}
