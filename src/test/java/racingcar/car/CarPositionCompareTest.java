package racingcar.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.CarPosition;

public class CarPositionCompareTest {

    @ParameterizedTest
    @DisplayName("차 위치값을 올바르게 비교한다.")
    @CsvSource(value = {
            "2,1,1", "1,1,0", "1,2,-1"
    })
    void CarPositionCompareTest(int positionValue1, int positionValue2, int expectedCompareResult) {
        // given
        CarPosition carPosition1 = new CarPosition();
        carPosition1.move(positionValue1);
        CarPosition carPosition2 = new CarPosition();
        carPosition2.move(positionValue2);

        // when
        int compareResult = carPosition1.compareTo(carPosition2);

        // then
        Assertions.assertEquals(compareResult, expectedCompareResult);
    }

}
