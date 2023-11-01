package racingcar;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.CarNameInput;

public class CarNameInputTest {

    private CarNameInput carNameInput;

    @BeforeEach
    void setUp() {
        carNameInput = new CarNameInput();
    }

    @Test
    void 쉼표를_기준으로_이름_구분_테스트() {
        // given
        String namesString = "pobi,woni,jun";

        // when
        List<String> parsedNames = carNameInput.parseCarNames(namesString);

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
        List<String> parsedNames = carNameInput.parseCarNames(namesString);

        // then
        assertEquals(3, parsedNames.size());
        assertTrue(parsedNames.contains("pobi"));
        assertTrue(parsedNames.contains("woni"));
        assertTrue(parsedNames.contains("jun"));
    }
}
