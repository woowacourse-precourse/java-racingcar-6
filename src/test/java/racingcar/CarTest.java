package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void Car_생성자_테스트() {
        String name = "red";

        Car car = new Car(name);

        assertEquals(name, car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    void move_테스트() {
        String name = "red";
        Car car = new Car(name);

        car.move();

        assertEquals(1, car.getPosition());
    }

    @Test
    void isMovablePower_true_반환_테스트() {
        String name = "red";
        int power = 5;
        Car car = new Car(name);

        assertTrue(car.isMovablePower(power));
    }

    @Test
    void isMovablePower_false_반환_테스트() {
        String name = "red";
        int power = 3;
        Car car = new Car(name);

        assertFalse(car.isMovablePower(power));
    }

    @Test
    void moveAttempt_테스트() {
        String input = "red";
        Car car = new Car(input);

        assertRandomNumberInRangeTest(
                () -> {
                    car.moveAttempt();
                    car.moveAttempt();
                    car.moveAttempt();
                    car.moveAttempt();
                    assertEquals(2, car.getPosition());
                },
                4, 5, 3
        );
    }
}
