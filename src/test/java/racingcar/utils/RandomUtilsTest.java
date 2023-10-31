package racingcar.utils;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.CarPosition;
import racingcar.config.RandomConfig;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void 랜덤_숫자의_범위_유효성_검사(){
        int randomNumber = randomUtils.makeRandomNumber();
        assertAll(
                ()->assertTrue(randomNumber>= RandomConfig.MIN_VALUE),
                ()->assertTrue(randomNumber<=RandomConfig.MAX_VALUE)
        );
    }

    @Test
    void 랜덤_숫자가_전진일때() {
        RandomUtils randomUtils = Mockito.mock(RandomUtils.class);

        Mockito.when(randomUtils.determinePositionByRandomNumber()).thenReturn(CarPosition.STRAIGHT);

        CarPosition position = randomUtils.determinePositionByRandomNumber();

        assertEquals(CarPosition.STRAIGHT, position);
    }

    @Test
    void 랜덤_숫자가_정지일때() {
        RandomUtils randomUtils = Mockito.mock(RandomUtils.class);

        Mockito.when(randomUtils.determinePositionByRandomNumber()).thenReturn(CarPosition.STOP);

        CarPosition position = randomUtils.determinePositionByRandomNumber();

        assertEquals(CarPosition.STOP, position);
    }
}
