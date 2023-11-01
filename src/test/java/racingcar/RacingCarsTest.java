package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    private static final String CAR_NAMES = "pobi,woni,jun";

    private RacingCars racingCars;

    @BeforeEach
    void 초기화() {
        racingCars = new RacingCars(CAR_NAMES);
    }

    @Test
    void 차_개수() {
        assertEquals(3, racingCars.size());
    }
}