package racingcar.ViewTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.View.InputView;

public class InputViewTest {

    @Test
    @DisplayName("자동차명 입력 테스트")
    public void requestCarNamesTest() {
        ByteArrayInputStream carNamesInput = new ByteArrayInputStream("ray,tico".getBytes());
        System.setIn(carNamesInput);
        String inputedCarNames = InputView.requestCarNames();
        System.setIn(System.in);

        assertEquals("ray,tico",inputedCarNames);
    }

    @Test
    @DisplayName("라운드 입력 테스트")
    public void requestRoundsTest() {
        ByteArrayInputStream roundsInput = new ByteArrayInputStream("5".getBytes());
        System.setIn(roundsInput);
        String inputedRounds = InputView.requestRounds();
        System.setIn(System.in);

        assertEquals("5",inputedRounds);
    }
}
