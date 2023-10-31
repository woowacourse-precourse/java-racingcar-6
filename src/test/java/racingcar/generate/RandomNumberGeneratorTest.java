package racingcar.generate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

@DisplayName("숫자 생성 테스트")
public class RandomNumberGeneratorTest {

    @DisplayName("생성된 숫자는 0에서 9 범위")
    @Test
    void checkRandomNumberBoundary() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        int randomNumber = numberGenerator.generateRandomNumber();

        assertThat(randomNumber).isBetween(0, 9);
    }

}
