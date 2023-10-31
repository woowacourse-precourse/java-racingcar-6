package racingcar.domain.inputhandler;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarNameInputterTest {

    @Test
    void Input_자동차_입력_확인() {
        CarNameInputter carNameInputter = new CarNameInputter();
        String carNames = "pobi,woni,jun";
        List<String> carNameList = carNameInputter.splitCarNames(carNames);
        assertEquals(Arrays.asList("pobi", "woni", "jun"), carNameList);
    }

    @Test
    void Valid_자동차_이름_유효성_확인() {
        CarNameInputter carNameInputter = new CarNameInputter();
        List<String> carNameList = Arrays.asList("pobi", "woni", "jun");
        boolean isValidCarName = carNameInputter.validateCarName(carNameList);
        assertTrue(isValidCarName);
    }

    @Test
    void InValid_자동차_이름_유효성_확인() {
        CarNameInputter carNameInputter = new CarNameInputter();
        List<String> carNameList = Arrays.asList("pobi", "swsoni", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            boolean isValidCarName = carNameInputter.validateCarName(carNameList);
        });
    }
}