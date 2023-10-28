package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatStateTest {

    @Test
    void true_일_경우_MOVING_반환() {
        CarState carState = CarState.from(true);

        assertEquals(carState, CarState.MOVING);
    }

    @Test
    void false_일경우_STOPPED_반환() {
        CarState carState = CarState.from(false);

        assertEquals(carState, CarState.STOPPED);
    }
}
