package racingcar.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void Car_객체_생성_시_이름이_정상적으로_부여되는지() {
        assertEquals("pobi", car.getName());
    }

    @Test
    void Car_객체_생성_시_루트가_빈칸인지() {
        assertEquals("", car.getRoute());
    }

    @Test
    void moveForward_루트가_한_칸씩_증가하는지() {
        car.moveForward();
        assertEquals("-", car.getRoute());
        car.moveForward();
        assertEquals("--", car.getRoute());
        car.moveForward();
        assertEquals("---", car.getRoute());
    }

    @RepeatedTest(100)
    void isMovable_정규분포_5시그마_테스트() {
        int movementCount = 0;
        int numberOfAttempts = 10000;
        for (int i = 0; i < numberOfAttempts; i++) {
            if (car.isMovable()) {
                movementCount++;
            }
        }

        double expectedMovablePercentage = 0.6;
        double actualMovablePercentage = (double) movementCount / numberOfAttempts;
        double sigma = Math.sqrt(expectedMovablePercentage * (1 - expectedMovablePercentage) / numberOfAttempts);
        assertEquals(expectedMovablePercentage, actualMovablePercentage, 5 * sigma);
    }
}