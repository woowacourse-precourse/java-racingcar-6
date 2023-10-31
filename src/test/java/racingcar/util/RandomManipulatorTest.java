package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.constant.Constants.MAX_RANDOM_VALUE;
import static racingcar.constant.Constants.MIN_RANDOM_VALUE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class RandomManipulatorTest {
    private RandomManipulator randomManipulator;
    private final int REPEAT_NUMBER = (MAX_RANDOM_VALUE - MIN_RANDOM_VALUE) * 10;

    @BeforeEach
    void beforeEach() {
        randomManipulator = new RandomManipulator();
    }

    @RepeatedTest(REPEAT_NUMBER)
    void pickNumber() {
        int result = randomManipulator.pickNumber();

        assertTrue((result >= MIN_RANDOM_VALUE) && (result <= MAX_RANDOM_VALUE));
    }
}