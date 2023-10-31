package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 사용자에게_경주할_자동차_이름들을_물어보는_출력문_테스트() {
        //given
        InputView inputView = new InputView();
        String expectedString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        //when
        inputView.printRequestCarName();

        //then
        assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }

    @Test
    void 사용자에게_시도횟수를_물어보는_출력문_테스트() {
        //given
        InputView inputView = new InputView();
        String expectedString = "시도할 회수는 몇회인가요?";

        //when
        inputView.printRequestAttemptsNumber();

        //then
        assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }

    @Test
    void 경주시작시_실행결과_출력문_테스트() {
        //given
        OutputView outputView = new OutputView();
        String expectedString = "실행결과";

        //when
        outputView.printRacingStartMessage();

        //then
        assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }


}
