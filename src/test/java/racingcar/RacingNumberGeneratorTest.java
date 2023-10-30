package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingNumberGenerator;

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
        for (int i = 0; i < 1000; i++) {  // 랜덤 값을 여러 번 생성하여 범위 내에 있는지 확인
            int generatedNumber = racingNumberGenerator.generate();

            assertThat(generatedNumber)
                    .isGreaterThanOrEqualTo(MIN_VALUE)
                    .isLessThanOrEqualTo(MAX_VALUE);
        }
    }
}
