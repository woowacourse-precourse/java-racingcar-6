package racingcar.domain.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void 테스트_함수_실행_전_실행() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void 테스트_함수_실행_후_실행() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("자동차 입력 문구 테스트")
    void printStartMessage() {
        InputView.printStartMessage();
        String outputMessage = outputStream.toString().trim();
        assertEquals(InputMessages.START.getMessage(), outputMessage);
    }

    @Test
    @DisplayName("시도 횟수 입력 문구 테스트")
    void printAttemptMessage() {
        InputView.printAttemptMessage();
        String outputMessage = outputStream.toString().trim();
        assertEquals(InputMessages.ATTEMPT.getMessage(), outputMessage);
    }
}