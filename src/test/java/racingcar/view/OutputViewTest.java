package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.view.OutputView.*;

class OutputViewTest {

    private final ByteArrayOutputStream testOutContent = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(testOutContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalSystemOut);
    }

    @Test
    public void 자동차_이름_프롬프트_출력() throws Exception {
        //given
        //when
        displayCarNamePrompt();
        //then
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", testOutContent.toString());
    }

    @Test
    public void 게임_시도_횟수_프롬프트_출력() throws Exception {
        //given
        //when
        displayAttemptPrompt();
        //then
        assertEquals("시도할 회수는 몇회인가요?\n", testOutContent.toString());
    }

    @Test
    public void 현재_게임_결과_출력() throws Exception {
        //given
        String carNameForTest = "pobi";
        String positionInDashes = "-";
        //when
        displayCurrentGameResult(carNameForTest, positionInDashes);
        //then
        assertEquals("pobi : -\n", testOutContent.toString());
    }

    @Test
    public void 결과_헤더_출력() throws Exception {
        //given
        //when
        displayResultHeader();
        //then
        assertEquals("\n실행 결과\n", testOutContent.toString());
    }

    @Test
    public void 우승자_출력() throws Exception {
        //given
        String winnerName = "pobi";
        //when
        displayWinner(winnerName);
        //then
        assertEquals("최종 우승자 : pobi\n", testOutContent.toString());
    }

}