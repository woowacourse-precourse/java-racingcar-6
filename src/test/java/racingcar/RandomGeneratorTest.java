package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.consts.GameConstant;
import racingcar.util.RandomGenerator;

public class RandomGeneratorTest {

    @Test
    @DisplayName("0~9사이의 랜덤숫자를 뽑아내는 기능 테스트")
    void testGenerate() {
        int generatedNumber;
        for (int i = 0; i < 100; i++) {
            generatedNumber = RandomGenerator.generate();
            assertThat(generatedNumber >= GameConstant.MIN_NUMBER_RANDOM_RANGE.get()
                    && generatedNumber <= GameConstant.MAX_NUMBER_RANDOM_RANGE.get()).isTrue();
        }
    }
}
