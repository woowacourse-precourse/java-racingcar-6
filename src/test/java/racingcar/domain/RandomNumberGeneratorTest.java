package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("0에서 9사이의 무작위 값을 하나 생성한다.")
    void generate() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        int result = numberGenerator.generate();

        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}