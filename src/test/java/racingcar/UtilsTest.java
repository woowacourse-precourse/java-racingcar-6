package racingcar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UtilsTest {
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6", "7", "8", "9"})
    void isMoveTest_True(String input) {
        // given
        int randomMovingNumber = Integer.valueOf(input);
        // when

        // then
        assertTrue(Utils.isMove(randomMovingNumber));
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3"})
    void isMoveTest_False(String input) {
        // given
        int randomMovingNumber = Integer.valueOf(input);
        // when

        // then
        assertFalse(Utils.isMove(randomMovingNumber));
    }
}
