package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void validateCarNames_null_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = null;
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNames_빈_문자열_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = "";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNames_공백_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = " ";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNames_개행_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = "\n";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}
