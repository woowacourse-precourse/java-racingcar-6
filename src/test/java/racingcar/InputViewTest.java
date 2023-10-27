package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    @DisplayName("자동차 입력 기능 테스트")
    @Test
    void testInputCarNamesToRace() {
        String expected = "pobi,woni,jun";
        String input = "pobi,woni,jun";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        String result = inputView.inputCarNamesToRace();

        assertEquals(expected, result);
    }
}
