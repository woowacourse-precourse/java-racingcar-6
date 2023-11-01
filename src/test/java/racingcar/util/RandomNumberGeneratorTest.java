package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.constant.Game;

public class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void 랜덤_숫자_생성() {
        assertThat(RandomNumberGenerator.generate())
                .isBetween(Game.MIN_RANDOM_NUMBER.is(), Game.MAX_RANDOM_NUMBER.is());
    }
}
