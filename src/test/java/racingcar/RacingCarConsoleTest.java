package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class RacingCarConsoleTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력받기_빈문자열_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String input = "";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));

                    RacingCarConsole racingCarConsole = new RacingCarConsole();
                    racingCarConsole.readCarNames();
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력받기_개행_예외_발생하지_않음() {
        Throwable result = catchThrowable(
                () -> {
                    String input = "\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));

                    RacingCarConsole racingCarConsole = new RacingCarConsole();
                    racingCarConsole.readCarNames();
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_입력받기_정상_처리() {
        Throwable result = catchThrowable(
                () -> {
                    String input = "홍길동,test,a맨\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));

                    RacingCarConsole racingCarConsole = new RacingCarConsole();
                    racingCarConsole.readCarNames();
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_양수_입력_정상처리() {
        Throwable result = catchThrowable(
                () -> {
                    String input = "3\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));

                    RacingCarConsole racingCarConsole = new RacingCarConsole();
                    racingCarConsole.readIterationNumBer();
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_0_입력_정상처리() {
        Throwable result = catchThrowable(
                () -> {
                    String input = "0\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));

                    RacingCarConsole racingCarConsole = new RacingCarConsole();
                    racingCarConsole.readIterationNumBer();
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_음수_입력_정상처리() {
        Throwable result = catchThrowable(
                () -> {
                    String input = "-12\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));

                    RacingCarConsole racingCarConsole = new RacingCarConsole();
                    racingCarConsole.readIterationNumBer();
                }
        );

        assertThat(result).doesNotThrowAnyException();
    }

    @Test
    void 시도_회수_입력받기_문자열_입력_예외처리() {
        Throwable result = catchThrowable(
                () -> {
                    String input = "-11abc#\n";
                    System.setIn(new ByteArrayInputStream(input.getBytes()));

                    RacingCarConsole racingCarConsole = new RacingCarConsole();
                    racingCarConsole.readIterationNumBer();
                }
        );

        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}
