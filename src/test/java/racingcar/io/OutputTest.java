package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class OutputTest {


    @Test
    void console_테스트() {
        String message = "hello, precourse!";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);
        Output.console(message);

        assertThat(outputStream.toString()).isEqualTo(message);
    }

    @Test
    void 인자가없는_consoleLine_테스트() {
        String expected = "\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);
        Output.consoleLine();

        assertThat(outputStream.toString()).isEqualTo(expected);
    }

    @Test
    void 기본_consoleLine_테스트() {
        String message = "hello, precourse!";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);
        Output.consoleLine(message);

        assertThat(outputStream.toString()).isEqualTo(message + "\n");
    }

}