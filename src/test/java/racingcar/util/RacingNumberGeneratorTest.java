package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingNumberGeneratorTest {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    private RacingNumberGenerator racingNumberGenerator;

    @BeforeEach
    void setUp() {
        racingNumberGenerator = new RacingNumberGenerator();
    }

    @Test
    void generate_ShouldReturnNumberBetweenZeroAndNine() {
        for (int i = 0; i < 1000; i++) {
            int generatedNumber = racingNumberGenerator.generate();
            assertThat(generatedNumber).isGreaterThanOrEqualTo(MIN_VALUE).isLessThanOrEqualTo(MAX_VALUE);
        }
    }
}
