package racingcar.domain.inputhandler;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNameInputterTest {

    @Test
    public void CarNameInputter() {
        CarNameInputter carNameInputter = new CarNameInputter();
        String carNames = "pobi,woni,jun";
        List<String> carNameList = carNameInputter.divineCarName(carNames);
        assertEquals(Arrays.asList("pobi", "woni", "jun"), carNameList);
    }
}