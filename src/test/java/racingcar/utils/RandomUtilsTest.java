package racingcar.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Constants;

import static org.junit.jupiter.api.Assertions.*;

public class RandomUtilsTest {

    @Test
    void createRandomNumberTest_True() {
        int output = RandomUtils.createRandomNumber(Constants.MIN_RANDOM_NUMBER,Constants.MAX_RANDOM_NUMBER);
        assertTrue(output >= 0 && output <= 9);
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "3","4"})
    void isMoveTest_True(int input) {
        assertTrue(RandomUtils.isMove(input));
    }

    @ParameterizedTest
    @CsvSource({"5","6","7","8","9"})
    void isMoveTest_False(int input) {
        assertFalse(RandomUtils.isMove(input));
    }
}
