package racingcar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class UtilsTest {
    @Test
    void generateRandomNumberTest() {
        int randomNumber = Utils.generateRandomNumber();

        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMoveTest_True(int trueInput) {
        assertTrue(Utils.isMove(trueInput));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isMoveTest_False(int falseInput) {
        assertFalse(Utils.isMove(falseInput));
    }
}