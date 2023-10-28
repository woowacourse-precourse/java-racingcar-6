package racingcar;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void 쉼표를_기준으로_이름_구분_테스트() {
        // given
        String namesString = "pobi,woni,jun";

        // when
        List<String> parsedNames = inputView.parseCarNames(namesString);

        // then
        assertEquals(3, parsedNames.size());
        assertTrue(parsedNames.contains("pobi"));
        assertTrue(parsedNames.contains("woni"));
        assertTrue(parsedNames.contains("jun"));
    }

    @Test
    void 공백_제거_테스트() {
        // given
        String namesString = " po bi , woni ,jun";

        // when
        List<String> parsedNames = inputView.parseCarNames(namesString);

        // then
        assertEquals(3, parsedNames.size());
        assertTrue(parsedNames.contains("pobi"));
        assertTrue(parsedNames.contains("woni"));
        assertTrue(parsedNames.contains("jun"));
    }
}
