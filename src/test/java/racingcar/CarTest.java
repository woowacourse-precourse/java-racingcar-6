package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

public class CarTest {
    @Test
    public void createCar() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.carName);
    }

    @Test
    public void verifyRandomNumberGeneration() {
        boolean isRandomNumberGeneratedProperly = true;

        for (int i = 0; i < 1000; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber < 0 || randomNumber > 9) {
                isRandomNumberGeneratedProperly = false;
                break;
            }
        }
        assertTrue(isRandomNumberGeneratedProperly);
    }
    @Test
    public void check_carStop() {
        Car car = new Car("pobi");
        car.move();
        assertEquals(0, car.carPosition);
    }

    @Test
    public void check_carMove() {
        Car car = new Car("pobi");
        car.move();
        assertEquals(1, car.carPosition);
    }
}