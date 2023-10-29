package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void makeCar() {
        //given
        RacingCar racingCar = new RacingCar("test");

        //when
        String name = racingCar.getName();
        int location = racingCar.getLocation();

        //then
        Assertions.assertEquals("test", name);
        Assertions.assertEquals(0, location);
    }

    @Test
    void canMoveFalse() {
        //given
        RacingCar racingCar = new RacingCar("test");

        //when
        boolean canMove = racingCar.canMove(3);

        //then
        Assertions.assertFalse(canMove);
    }

    @Test
    void canMoveTrue() {
        //given
        RacingCar racingCar = new RacingCar("test");

        //when
        boolean canMove = racingCar.canMove(4);

        //then
        Assertions.assertTrue(canMove);
    }

    @Test
    void moveCar() {
        //given
        RacingCar racingCar = new RacingCar("test");

        //when
        racingCar.move(true);
        int location = racingCar.getLocation();

        //then
        Assertions.assertEquals(1, location);
    }
}
