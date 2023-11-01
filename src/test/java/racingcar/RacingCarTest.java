package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    @Test
    void createRacingCarWithName() {
        String name = "test";
        RacingCar car = new RacingCar(name);
        assertEquals(name, car.getName());
    }

    @Test
    void moveRacingCar() {
        RacingCar car = new RacingCar("test");
        car.move(5); // 전진 조건에 만족한다고 가정할 때
        assertEquals(1, car.getPosition());
    }

    @Test
    void notMoveRacingCar() {
        RacingCar car = new RacingCar("test");
        car.move(3); // 전진 조건에 만족하지 않을 때
        assertEquals(0, car.getPosition());
    }
}
