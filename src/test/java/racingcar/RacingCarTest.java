package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차_생성() {
        RacingCar racingCar = new RacingCar("jihun");

        assertEquals("jihun", racingCar.getName());
    }
}