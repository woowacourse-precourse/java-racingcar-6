package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @Test
    void 까지의_랜덤_숫자_생성_테스트() {
        int result = RandomGenerator.generateNumber();

        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThanOrEqualTo(9);
    }
}