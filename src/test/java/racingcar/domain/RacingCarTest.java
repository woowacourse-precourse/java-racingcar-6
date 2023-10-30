package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void new_자동차_이름이_5자를_초과하면_예외를_던진다() {
        String invalidCarName = "JESICA";

        assertThrows(IllegalArgumentException.class, () -> new RacingCar(invalidCarName));
    }

    @Test
    void new_자동차_이름이_5자_이하면_객체가_정상적으로_생성된다() {
        String validCarName = "JAMES";

        RacingCar racingCar = new RacingCar(validCarName);

        assertEquals(validCarName, racingCar.getName());
    }

    @Test
    void move_자동차가_움직이면_거리가_1_증가한다() {
        RacingCar racingCar = new RacingCar("car");

        racingCar.move();

        assertEquals(1, racingCar.getDistance());
    }
}
