package racingcar.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    @Test
    @DisplayName("generate 함수는 min 이상 max 이하의 사이의 숫자를 반환한다")
    void generate_test() {
        // given
        int minInclusive = 0;
        int maxInclusive = 9;

        // when
        RandomNumberGenerator generator = new RandomNumberGenerator(minInclusive, maxInclusive);
        int randomNumber = generator.generate();

        // then
        assertThat(randomNumber).isBetween(minInclusive, maxInclusive);
    }
}
