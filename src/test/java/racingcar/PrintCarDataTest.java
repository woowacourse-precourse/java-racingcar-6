package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrintCarDataTest {
    @Test
    void 이동거리에_대한_출력이_제대로_이루어지는지_확인(){
        int movingDistance = 5;
        PrintCarData printCarData = new PrintCarData();
        String printCarDistance = printCarData.printRacingCarDistance(movingDistance);
        Assertions.assertThat(printCarDistance.equals("-----"));
    }
}
