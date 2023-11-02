package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UtilTest {
    private final static int START_INCLUSIVE = 0;
    private final static int END_INCLUSIVE = 9;

    @Test
    void randomNumberRangeTest_RandomNumber_True() {
        int randomNumber = Util.generateRandomNumber();

        assertTrue(randomNumber >= START_INCLUSIVE && randomNumber <= END_INCLUSIVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMoveTest_MoreThan4_True(int trueInput) {
        assertTrue(Util.isMove(trueInput));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isMoveTest_LessThan3_False(int falseInput) {
        assertFalse(Util.isMove(falseInput));
    }
}