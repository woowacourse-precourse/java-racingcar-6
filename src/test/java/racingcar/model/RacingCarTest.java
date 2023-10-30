package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @DisplayName("자동차 전진 기능")
    @Test
    void move() {
        RacingCar racingCar = new RacingCar("name");
        assertAll(
                () -> assertTrue(racingCar.move(4)),
                () -> assertFalse(racingCar.move(3))
        );
    }
}