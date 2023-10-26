package racingcar.domain.car.carcomponent;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.car.carcomponent.CarPositionCompareResult.BIG;
import static racingcar.domain.car.carcomponent.CarPositionCompareResult.SAME;
import static racingcar.domain.car.carcomponent.CarPositionCompareResult.SMALL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPositionTest {

    private static final int BIG_NUMBER = 3;
    private static final int SMALL_NUMBER = 2;

    @Test
    @DisplayName("CarPosition 비교시 작으면 CarPositionCompare.SMALL 을 반환한다")
    void carPositionCompareTest_1() {
        CarPosition carPosition_1 = new CarPosition(SMALL_NUMBER);
        CarPosition carPosition_2 = new CarPosition(BIG_NUMBER);
        CarPositionCompareResult carPositionCompareResult = carPosition_1.compare(carPosition_2);
        assertThat(carPositionCompareResult).isEqualTo(SMALL);
    }

    @Test
    @DisplayName("CarPosition 비교시 크면 CarPositionCompare.BIG 을 반환한다")
    void carPositionCompareTest_2() {
        CarPosition carPosition_1 = new CarPosition(BIG_NUMBER);
        CarPosition carPosition_2 = new CarPosition(SMALL_NUMBER);
        CarPositionCompareResult carPositionCompareResult = carPosition_1.compare(carPosition_2);
        assertThat(carPositionCompareResult).isEqualTo(BIG);
    }

    @Test
    @DisplayName("CarPosition 비교시 같으면 CarPositionCompare.SAME 을 반환한다")
    void carPositionCompareTest_3() {
        CarPosition carPosition_1 = new CarPosition(BIG_NUMBER);
        CarPosition carPosition_2 = new CarPosition(BIG_NUMBER);
        CarPositionCompareResult carPositionCompareResult = carPosition_1.compare(carPosition_2);
        assertThat(carPositionCompareResult).isEqualTo(SAME);
    }
}
