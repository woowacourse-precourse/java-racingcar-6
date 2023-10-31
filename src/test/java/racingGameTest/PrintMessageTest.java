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

    static ByteArrayOutputStream output;
    static PrintStream basicOut;

    @BeforeEach
    void setPrint() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        basicOut = System.out;
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

//    @Test
//    void inputTryCountMessage() {
//        RacingGameView.inputTryCount();
//        assertEquals(Constant.INPUT_TRY_COUNT, output.toString().trim());
//    }

    @Test
    void gameResultMessage() {
        RacingGameView.gameResultMessage();
        assertEquals(Constant.GAME_RESULT, output.toString().trim());
    }

    @Test
    void carNameAndForwardResultMessage() {
        String carNameForwardString = "test : -";
        HashMap<String, Integer> carNameForward = new HashMap<>();
        carNameForward.put("test", 1);
        RacingGameView.forwardResult(carNameForward);
        assertEquals(carNameForwardString, output.toString().trim());
    }
}
