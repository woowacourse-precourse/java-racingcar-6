package racingcar.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RandomUtilsTest {

    @Test
    void createRandomNumberTest_True() {
        int output = RandomUtils.createRandomNumber();
        assertTrue(output >= 0 && output <= 9);
    }
}
