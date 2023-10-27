package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {
    InputView inputView;
    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    public void reset() {
        Console.close();
    }

    @DisplayName("자동차 입력 기능 테스트")
    @Test
    void testInputCarNamesToRace() {
        String expected = "pobi,woni,jun";
        String input = "pobi,woni,jun";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = inputView.inputCarNamesToRace();

        assertEquals(expected, result);
    }

    @DisplayName("시도 회수 입력 기능 테스트")
    @Test
    void testInputNumberOfTry() {
        String expected = "5";
        String input = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = inputView.inputNumberOfTry();

        assertEquals(expected, result);
    }
}
