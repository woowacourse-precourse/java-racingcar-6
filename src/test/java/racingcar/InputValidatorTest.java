package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void 자동자_전체_이름_검증_null_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = null;
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동자_전체_이름_검증_빈_문자열_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = "";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동자_전체_이름_검증_공백_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = " ";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동자_전체_이름_검증_개행_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = "\n";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동자_전체_이름_검증_정상처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carNames = "홍길동,test,a맨";
                    InputValidator.validateCarNames(carNames);
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 하나의_자동차_이름_검증_한글_정상처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "홍길동";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 하나의_자동차_이름_검증_영어_정상처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "Asus";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 하나의_자동차_이름_검증_빈_문자열_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 하나의_자동차_이름_검증_5자_초과_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "superMan";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 하나의_자동차_이름_검증_개행_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "\n";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 하나의_자동차_이름_검증_숫자_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String carName = "666";
                    InputValidator.validateCarName(carName);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_검증_양수_정상처리() {
        Throwable result = catchThrowable(
                () -> {
                    InputValidator.validateIterationNumBer(5);
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_검증_0_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    InputValidator.validateIterationNumBer(0);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_검증_음수_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    InputValidator.validateIterationNumBer(-12);
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}
