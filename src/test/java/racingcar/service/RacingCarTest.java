package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    public void constructor_test() {
        // given
        RacingCar racingCar = new RacingCar("test");

        // when
        String name = racingCar.getName();
        int advanceDistance = racingCar.getAdvanceDistance();

        // then
        assertEquals(name, "test");
        assertEquals(advanceDistance, 0);
    }

    @Test
    public void isAdvancedTarget_underThreshold_false() {
        // given
        int generatedNum = 3;

        // when
        boolean result = RacingCar.isAdvancedTarget(generatedNum);

        // then
        assertFalse(result);
    }

    @Test
    public void isAdvancedTarget_equalThreshold_false() {
        // given
        int generatedNum = 4;

        // when
        boolean result = RacingCar.isAdvancedTarget(generatedNum);

        // then
        assertTrue(result);
    }

    @Test
    public void advanceByNumber_underThreshold_noAdvance() {
        // given
        int generatedNum =  3;
        RacingCar racingCar = new RacingCar("test");

        // when
        racingCar.advanceByNumber(generatedNum);

        // then
        assertEquals(racingCar.getAdvanceDistance(), 0);
    }

    @Test
    public void advanceByNumber_overThreshold_advance() {
        // given
        int generatedNum = 5;
        RacingCar racingCar = new RacingCar("test");

        // when
        racingCar.advanceByNumber(generatedNum);

        // then
        assertEquals(racingCar.getAdvanceDistance(), 1);
    }
}