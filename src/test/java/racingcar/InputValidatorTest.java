package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @Test
    void 자동차_대수가_최소대수보다_작으면_예외_발생() {
        List<String> carNames = List.of("car");

        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_CAR_COUNT);
    }

    @Test
    void 자동차_대수가_최대대수보다_크면_예외_발생() {
        List<String> carNames = Stream.generate(() -> "car")
                .limit(101)
                .toList();

        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_CAR_COUNT);
    }

    @Test
    void 자동차_이름이_최대길이보다_길면_예외_발생() {
        List<String> carNames = List.of("car123456", "car123456");

        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_CAR_NAME_LENGTH);
    }

    @Test
    void 자동차_이름이_최소길이보다_짧으면_예외_발생() {
        List<String> carNames = List.of("", "");

        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_CAR_NAME_LENGTH);
    }

    @Test
    void 자동차_이름에_공백이_포함되면_예외_발생() {
        List<String> carNames = List.of("c ar", "ca r");

        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_CAR_NAME_WHITESPACE);
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> validator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_ATTEMPT_COUNT_TYPE);
    }

    @Test
    void 시도_횟수가_정수가_아니면_예외_발생() {
        String input = "11.11";

        assertThatThrownBy(() -> validator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_ATTEMPT_COUNT_TYPE);
    }

    @Test
    void 시도_횟수가_최소값보다_작으면_예외_발생() {
        String input = "-1";

        assertThatThrownBy(() -> validator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_ATTEMPT_COUNT_RANGE);
    }

    @Test
    void 시도_횟수가_최대값보다_크면_예외_발생() {
        String input = "1000001";

        assertThatThrownBy(() -> validator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.INVALID_ATTEMPT_COUNT_RANGE);
    }

}
