package racingGameTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import racingcar.Constant;
import racingcar.view.RacingGameView;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintMessageTest {

    static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    static final PrintStream basicOut = System.out;

    @BeforeEach
    void setPrint() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restorePrint() {
        System.setOut(basicOut);
    }

    @Test
    void inputCarNameMessage() {
        RacingGameView.inputCarNameMessage();
        assertEquals(Constant.INPUT_CAR_NAME, output.toString().trim());
    }

    @Test
    void inputTryCountMessage() {
        RacingGameView.inputTryCountMessage();
        assertEquals(Constant.INPUT_TRY_COUNT, output.toString().trim());
    }

    @Test
    void gameResultMessage() {
        RacingGameView.gameResultMessage();
        assertEquals(Constant.GAME_RESULT, output.toString().trim());
    }

    @Test
    void carNameAndForwardResultMessage() {
        String carNameForwardString = "test : -";
        HashMap<String, String> carNameForward = new HashMap<>();
        carNameForward.put("test", "-");
        RacingGameView.forwardResult(carNameForward);
        assertEquals(carNameForwardString, output.toString().trim());
    }
}
