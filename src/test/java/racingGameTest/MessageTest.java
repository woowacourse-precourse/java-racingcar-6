package racingGameTest;


import racingcar.Constant;
import racingcar.view.RacingGameView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {

    private ByteArrayOutputStream outPut;
    private PrintStream basicOut;

    @BeforeEach
    public void setPrint() {
        basicOut = System.out;
        outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
    }

    @AfterEach
    public void restorePrint() {
        System.setOut(basicOut);
        System.out.println(outPut);
    }

    @Test
    @DisplayName("자동차 이름 입력 안내 메세지")
    void inputCarNameMessage() {
        RacingGameView.inputCarNameMessage();
        assertEquals(Constant.INPUT_CAR_NAME, outPut.toString().trim());
    }

    @Test
    @DisplayName("시도 횟수 입력 안내 메세지")
    void inputTryCountMessage() {
        RacingGameView.inputTryCountMessage();
        assertEquals(Constant.INPUT_TRY_COUNT, outPut.toString().trim());
    }

    @Test
    @DisplayName("실행 결과 안내 메세지")
    void gameResultMessage() {
        RacingGameView.gameResultMessage();
        assertEquals(Constant.GAME_RESULT, outPut.toString().trim());
    }

    @Test
    @DisplayName("자동차 이름, 전진 횟수 메세지")
    void carNameAndForwardResultMessage() {
        String carNameForwardString = "test : -";
        HashMap<String, Integer> carNameForward = new HashMap<>();
        carNameForward.put("test", 1);
        RacingGameView.forwardResult(carNameForward);
        assertEquals(carNameForwardString, outPut.toString().trim());
    }
}
