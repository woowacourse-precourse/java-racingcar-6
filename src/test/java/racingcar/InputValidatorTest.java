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

    @Test
    void validateCarNames_정상_처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = "홍길동,test,a맨";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void validateCarName_정상_처리_한글() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "홍길동";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void validateCarName_정상_처리_영어() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "Asus";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void validateCarName_빈_문자열_예외_처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_5자_초과_예외_처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "superMan";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_개행_예외_처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "\n";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarName_숫자_예외_처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "666";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}
