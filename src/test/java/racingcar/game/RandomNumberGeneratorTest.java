package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    void 지정된_범위안의_랜덤한_숫자만_반환한다() {
        //given
        int startInclusive = 0;
        int endInclusive = 9;
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        //when
        int randomNumber = numberGenerator.generate(startInclusive, endInclusive);

        //then
        Assertions.assertThat(randomNumber).isGreaterThanOrEqualTo(startInclusive)
                .isLessThanOrEqualTo(endInclusive);
    }
}