package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarPositionMoveTest {

    private CarPosition carPosition;

    @BeforeEach()
    void setup() {
        carPosition = new CarPosition();
    }

    @ParameterizedTest
    @DisplayName("차의 위치값이 증감값에 대해 올바르게 이동한다.")
    @CsvSource(value = {
            "1,1,2", "0,0,0", "-1,-1,-2", "1,-1,0"
    })
    void carPositionMoveTest(int value1, int value2, int expectedPosition) {
        // when
        carPosition.move(value1);
        carPosition.move(value2);
        int position = carPosition.getPosition();

        // then
        Assertions.assertEquals(position, expectedPosition);
    }

}
