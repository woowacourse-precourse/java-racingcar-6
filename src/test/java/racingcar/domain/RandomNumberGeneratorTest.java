package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void generate_메서드는_0에서_9사이의_값을_반환한다() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}
