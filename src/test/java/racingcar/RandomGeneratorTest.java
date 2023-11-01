package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.consts.GameConstant.MAX_NUMBER_RANDOM_RANGE;
import static racingcar.consts.GameConstant.MIN_NUMBER_RANDOM_RANGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;

public class RandomGeneratorTest {

    @Test
    @DisplayName("0~9사이의 랜덤숫자를 뽑아내는 기능 테스트")
    void testGenerate() {
        int generatedNumber;
        for (int i = 0; i < 100; i++) {
            generatedNumber = RandomGenerator.generate();
            assertThat(generatedNumber >= MIN_NUMBER_RANDOM_RANGE.get()
                    && generatedNumber <= MAX_NUMBER_RANDOM_RANGE.get()).isTrue();
        }
    }
}
