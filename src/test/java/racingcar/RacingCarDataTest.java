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

    @Test
    void 이동거리에_대한_업데이트_여부가_제대로_이루어지는지_확인(){
        int randomNumber1 = 6;
        RacingCarData racingCarData = new RacingCarData();
        int currentNumber1 = racingCarData.updateRacingCarDistance(randomNumber1);
        Assertions.assertThat(currentNumber1).isEqualTo(1);

        int randomNumber2 = 3;
        int currentNumber2 = racingCarData.updateRacingCarDistance(randomNumber2);
        Assertions.assertThat(currentNumber2).isEqualTo(0);
    }
}
