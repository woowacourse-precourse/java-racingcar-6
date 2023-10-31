package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class PrintCarDataTest {
    @Test
    void 이동거리에_대한_출력이_제대로_이루어지는지_확인(){
        int movingDistance = 5;
        PrintCarData printCarData = new PrintCarData();
        String printCarDistance = printCarData.printRacingCarDistance(movingDistance);
        Assertions.assertThat(printCarDistance.equals("-----"));
    }

    @Test
    void 우승자가_제대로_출력되는지_확인(){
        int tryNumber = 5;
        LinkedHashMap<String, Integer> racingCarNames = new LinkedHashMap<>();
        racingCarNames.put("pobi", 5);
        racingCarNames.put("woni", 3);
        racingCarNames.put("jun", 5);

        PrintCarData printCarData = new PrintCarData();
        String winCarName = printCarData.printWinRacingCar(racingCarNames, tryNumber);

        Assertions.assertThat(winCarName.contains("pobi"));
        Assertions.assertThat(winCarName.contains("jun"));
    }
}
