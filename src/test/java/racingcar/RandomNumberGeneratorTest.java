package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.underhood.GameRule;

public class RandomNumberGeneratorTest {

    @Test
    void 지정된_범위의_난수_생성() {
        // given
        int minInclude = 0;
        int maxInclude = 9;
        GameRule rule = new GameRule(minInclude, maxInclude);
        // when
        int randomNumber = RandomNumberGenerator.pickRandomNumber(rule);
        // then
        assertThat(randomNumber).isBetween(minInclude, maxInclude);
    }
}
