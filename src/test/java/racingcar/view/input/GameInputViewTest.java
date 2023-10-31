package racingcar.view.input;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameInputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

        final byte[] buf = String.join("\n", "1").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 게임_input_입력시_정상적으로_InputMessage가_출력된다() {
        GameInputView.requestInput(GameInputMessage.INPUT_CAR_NAME);
        Assertions.assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", outContent.toString().trim());
    }

}