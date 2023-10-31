package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        printStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(printStream);
    }

    @Test
    void 게임을_시작할때_이름들을_입력받는_문구를_출력한다() {
        String expected = OutputMessage.INPUT_NAMES.message + "\n";

        Output.printInputNames();

        String output = outputStream.toString();
        assertEquals(expected, output);
    }

}