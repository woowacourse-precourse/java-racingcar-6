package racingcar.policy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumberGeneratePolicyTest {

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition} / {totalRepetitions}")
    void 정책에_따라_0부터_9까지의_수를_생성한다() {
        // given
        RandomNumberGeneratePolicy randomNumberGeneratePolicy = new RandomNumberGeneratePolicy();

        // when
        int generate = randomNumberGeneratePolicy.generate();

        // then
        assertThat(generate).isBetween(0, 9);
    }

}