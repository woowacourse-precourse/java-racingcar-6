package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void carMoveTest_1칸_움직이기_테스트() {
        RacingCar racingCar = new RacingCar("test");
        racingCar.moveOneBlock();

        Assertions.assertThat(racingCar.getCount()).isEqualTo(1);
    }

}
