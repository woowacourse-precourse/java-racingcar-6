package racingcar.ViewTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import camp.nextstep.edu.missionutils.Console;
import racingcar.View.InputView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    @AfterEach
    public void resetScanner() {
        Console.close();
    }

    @Test
    @DisplayName("자동차명 입력 테스트")
    public void requestCarNamesTest() {
        setInput("ray,tico");
        String inputedCarNames = InputView.requestCarNames();
        assertEquals("ray,tico", inputedCarNames);
    }

    @Test
    @DisplayName("라운드명 입력 테스트")
    public void requestRoundsTest() {
        setInput("5");
        String inputedRounds = InputView.requestCarNames();
        assertEquals("5", inputedRounds);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
