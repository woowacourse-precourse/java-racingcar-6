package racingcar.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

    private static final String MESSAGE = "출력 테스트 메세지입니다.";

    private Output output;
    private ByteArrayOutputStream outputStream;

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