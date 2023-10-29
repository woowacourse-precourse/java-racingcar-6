package racingcar.domain.caractions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class RandomNumberGeneratorTest {
    private RandomNumberGenerator NumberGenerator;

    @BeforeEach
    public void setUp() {
        NumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void getNumberTest() {
        int Number = NumberGenerator.getNumber();
        assertTrue(Number == 0 || Number == 1);
    }
}