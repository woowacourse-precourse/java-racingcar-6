package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatStateTest {

    @Test
    void true_일_경우_MOVE_반환() {
        CarState carState = CarState.from(true);

        assertEquals(carState, CarState.MOVE);
    }

    @Test
    void false_일경우_STOP_반환() {
        CarState carState = CarState.from(false);

        assertEquals(carState, CarState.STOP);
    }
}
