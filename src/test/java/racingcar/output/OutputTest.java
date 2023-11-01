package racingcar.output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {
    private Output output;
    private ByteArrayOutputStream outputStream;
    private static final String MESSAGE = "출력 테스트 메세지입니다.";

    @BeforeEach
    void setUp() {
        output = new Output();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void object를_출력() {
        //when
        output.print(MESSAGE);

        //then
        String printedMessage = outputStream.toString().trim();
        assertThat(printedMessage).isEqualTo(MESSAGE);
    }
}