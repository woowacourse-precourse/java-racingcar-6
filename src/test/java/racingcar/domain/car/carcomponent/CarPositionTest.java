package racingcar.domain.car.carcomponent;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.car.carcomponent.CarPositionCompareResult.BIG;
import static racingcar.domain.car.carcomponent.CarPositionCompareResult.SAME;
import static racingcar.domain.car.carcomponent.CarPositionCompareResult.SMALL;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPositionTest {

    private static final int THREE = 3;
    private static final int TWO = 2;
    private CarPosition carPosition_Three;
    private CarPosition carPosition_Two;

    @BeforeEach
    void init() {
        carPosition_Three = new CarPosition(THREE);
        carPosition_Two = new CarPosition(TWO);
    }

    @Test
    @DisplayName("CarPosition 비교시 position 이 작으면 CarPositionCompare.SMALL 을 반환한다")
    void carPositionCompareTest_1() {
        CarPositionCompareResult carPositionCompareResult = carPosition_Two.compare(carPosition_Three);
        assertThat(carPositionCompareResult).isEqualTo(SMALL);
    }

    @Test
    @DisplayName("CarPosition 비교시 position 이 크면 CarPositionCompare.BIG 을 반환한다")
    void carPositionCompareTest_2() {
        CarPositionCompareResult carPositionCompareResult = carPosition_Three.compare(carPosition_Two);
        assertThat(carPositionCompareResult).isEqualTo(BIG);
    }

    @Test
    @DisplayName("CarPosition 비교시 position 이 같으면 CarPositionCompare.SAME 을 반환한다")
    void carPositionCompareTest_3() {
        CarPosition carPosition_Three_2 = new CarPosition(THREE);
        CarPositionCompareResult carPositionCompareResult = carPosition_Three.compare(carPosition_Three_2);
        assertThat(carPositionCompareResult).isEqualTo(SAME);
    }

    @Test
    @DisplayName("CarPosition 에서 move 메서드를 사용하면 position 이 1 증가한 객체를 반환한다")
    void carPositionMoveTest() {
        carPosition_Two = carPosition_Two.move();
        CarPositionCompareResult carPositionCompareResult = carPosition_Two.compare(carPosition_Three);
        Assertions.assertThat(carPositionCompareResult).isEqualTo(SAME);
    }

    @Test
    @DisplayName("carPosition_Two 에서 move 메서드로 position 1증가 시키면, 결과값 메세지로 '-' 3개를 반환한다.")
    void carPositionResultMessageTest() {
        carPosition_Two = carPosition_Two.move();
        Assertions.assertThat(carPosition_Two.makePositionResultMessage()).isEqualTo("---");
    }
}
