package racingcar.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.strategy.RandomNumberGenerator.RandomNumberGeneratorImpl;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumberGeneratorTest {


    @RepeatedTest(100)
    void _0에서_9사이의_숫자가_생성됩니다() {

        assertThat(new RandomNumberGeneratorImpl().generate())
                .isBetween(0, 9);
    }

}