package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class RacingCarDataTest {
    @Test
    void 입력값이_제대로_분리되는지_확인(){
        String carNameInput = "pobi,woni";
        RacingCarData racingCarData = new RacingCarData();
        LinkedHashMap<String, Integer> racingCarNames = racingCarData.separateRacingCar(carNameInput);
        Assertions.assertThat(racingCarNames.containsKey("pobi"));
        Assertions.assertThat(racingCarNames.containsKey("woni"));
    }
}
