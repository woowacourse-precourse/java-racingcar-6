package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void generate는_1_9사이의_랜덤숫자를_생성한다() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < 1000; i++) {
            assertThat(randomNumberGenerator.generate()).isBetween(1, 9);
        }
    }
}
