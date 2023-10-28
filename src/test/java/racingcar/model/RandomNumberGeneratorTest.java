package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 램덤으로_숫자를_생성하는_경우_범위에_맞는_값만_생성한다() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int min = 0;
        int max = 9;

        int actual = numberGenerator.generateBetween(min, max);

        assertThat(actual).isBetween(min, max);
    }
}
