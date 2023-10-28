package racingcar.domain.caractions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class RandomStepGeneratorTest {
    private RandomStepGenerator stepGenerator;

    @BeforeEach
    public void setUp() {
        stepGenerator = new RandomStepGenerator();
    }

    @Test
    void getStepTest() {
        int step = stepGenerator.getStep();
        assertTrue(step == 0 || step >= 4);
    }
}