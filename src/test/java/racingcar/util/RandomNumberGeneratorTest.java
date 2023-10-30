package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.Constant.END_INCLUSIVE;
import static racingcar.util.Constant.START_INCLUSIVE;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class RandomNumberGeneratorTest {

    @Test
    void 게임의_규칙대로_랜덤_숫자를_만든다() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        // when
        int generate = numberGenerator.generate();

        // then
        assertThat(generate).isBetween(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue());
    }
}
