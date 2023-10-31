package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    private static final Integer MIN_NUMBER = 0;
    private static final Integer MAX_NUMBER = 9;

    private NumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        numberGenerator = new RandomNumberGenerator();
    }

    @DisplayName("생성한 난수는 0보다 크고 9보다 작아야 한다.")
    @Test
    void pickNumberInRange_test() {
        Integer result = numberGenerator.pickNumber();

        assertTrue(result >= MIN_NUMBER);
        assertTrue(result <= MAX_NUMBER);
    }
}
