package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.ConsoleTestSuper;

class OutputTest extends ConsoleTestSuper {


    @Test
    void console_테스트() {
        String message = "hello, precourse!";

        Output.console(message);

        assertThat(outputStream.toString()).isEqualTo(message);
    }

    @Test
    void 인자가없는_consoleLine_테스트() {
        String expected = "\n";

        Output.consoleLine();

        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    void 기본_consoleLine_테스트() {
        String message = "hello, precourse!";

        Output.consoleLine(message);

        assertThat(outputStream.toString()).isEqualTo(message + "\n");
    }

}