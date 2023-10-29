package racingcar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UtilsTest {
    @ParameterizedTest
    @CsvSource({"4", "5", "6", "7", "8", "9"})
    void isMoveTest_True(int input) {
        // given

        // when

        // then
        assertTrue(Utils.isMove(input));
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void isMoveTest_False(int input) {
        // given

        // when

        // then
        assertFalse(Utils.isMove(input));
    }
}
