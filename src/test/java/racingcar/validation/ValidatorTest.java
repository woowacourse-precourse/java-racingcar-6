package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 자동차_이름_정상_입력() {
        List<String> input = Arrays.asList("a", "b", "c");

        assertThatCode(() -> {
            Validator.validateCarsInput(input);
        }).doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_비정상_입력시_IllegalArgumentException_발생() {
        List<String> input = Arrays.asList("abcdef,b,c");

        assertThatThrownBy(() -> {
            Validator.validateCarsInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_정상_입력() {
        String input = "10";

        assertThatCode(() -> {
            Validator.validateTurnInput(input);
        }).doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수_비정상_입력시_IllegalArgumentException_발생() {
        String input = "a";

        assertThatThrownBy(() -> {
            Validator.validateTurnInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
