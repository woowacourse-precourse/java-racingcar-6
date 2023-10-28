package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0 에서 9 사이의 랜덤 값을 생성")
    void givenGenerator_whenGenerate_thenReturnRandomNumber() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        int result = randomNumberGenerator.generate();

        // then
        assertThat(result).isBetween(0, 9);
    }

}
