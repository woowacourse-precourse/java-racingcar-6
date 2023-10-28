package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class RandomNumberGeneratorTest {

    @Test
    void 범위에_맞는_랜덤_숫자를_반환한다() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        // when
        int generate = numberGenerator.generate();

        // then
        assertThat(generate).isBetween(0, 9);
    }
}
