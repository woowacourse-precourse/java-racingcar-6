package racingcar.util.generator;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    void 랜덤한_한자리_숫자를_반환() {
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        final int generatedNumber = randomNumberGenerator.generate();

        boolean actual = generatedNumber > 0 && generatedNumber < 10;
        assertThat(actual).isTrue();
    }
}
