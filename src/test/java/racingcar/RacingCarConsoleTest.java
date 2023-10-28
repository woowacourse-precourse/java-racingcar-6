package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class RacingCarConsoleTest {

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
}
