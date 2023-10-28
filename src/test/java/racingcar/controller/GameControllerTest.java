package racingcar.controller;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCarList;

public class GameControllerTest {
    private GameController controller;
    @BeforeEach
    void setUp() {
        controller = new GameController();
    }

    @Test
    void 입력된_레이상카_리스트에_추가(){
        controller.addRacingCar(Arrays.asList("abc","def","ghi"));
        assertThat(controller.racingCarList).hasOnlyElementsOfType(RacingCarList.class);
    }
}
