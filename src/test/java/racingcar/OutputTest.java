package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.Output.*;

public class OutputTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut((new PrintStream(output)));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }
    @Test
     void printCarNameInputRequestTest() {
        printCarNameInputRequest();
        assertThat(output.toString()).isEqualTo(CAR_NAME_INPUT_REQUEST_MESSAGE+"\r\n");
    }
}
