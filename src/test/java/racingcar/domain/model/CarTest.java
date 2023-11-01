package racingcar.domain.model;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car("Taycan");
    }

    @Test
    public void carMovesWhenRandomIsAboveThreshold() {
        Assertions.assertRandomNumberInRangeTest(() -> {
            car.move();
            assertEquals(1, car.getPosition());
        }, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void carDoesNotMoveWhenRandomIsBelowThreshold() {
        Assertions.assertRandomNumberInRangeTest(() -> {
            car.move();
            assertEquals(0, car.getPosition());
        }, 0, 1, 2, 3);
    }
}
