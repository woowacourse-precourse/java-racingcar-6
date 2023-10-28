package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private final InputView inputView = new InputView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값 입력 시 테스트")
    public void testInputTotalRoundNotNumeric() {
        InputStream readLine = setReadLine("abc");
        System.setIn(readLine);

        assertThrows(IllegalArgumentException.class, inputView::inputTotalRound);
    }

    private InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
