package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {

    @Test
    @DisplayName("자동차가 이동한만큼 이동거리가 증가하는지 테스트")
    void testMoveWhenRandomNumberIsLessThan4() {
        RacingCar racingCar = new RacingCar("페라리");
        int expectedMovement = 0;

        //when
        for (int i = 0; i < 10; i++) {
            if (racingCar.move()) {
                expectedMovement++;
            }
        }

        //then
        assertEquals(expectedMovement, racingCar.getMovement());
    }

}