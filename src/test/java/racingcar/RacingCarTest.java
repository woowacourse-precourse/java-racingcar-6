package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {

    @Test
    @DisplayName("자동차가 이동한만큼 이동거리가 증가하는지 테스트")
    void testMoveWhenRandomNumberIsLessThan4() {
        RacingCar racingCar = new RacingCar("페라리");
        StringBuilder expectedMovement = new StringBuilder();

        //when
        for (int i = 0; i < 10; i++) {
            if (racingCar.move()) {
                expectedMovement.append("-");
            }
        }

        //then
        assertEquals(expectedMovement.toString(), racingCar.getMovement());
    }
}