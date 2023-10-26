package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("올바른 범위의 랜덤한 숫자 생성 테스트")
    @Test
    void checkRandomNumberGenerate() {
        assertThat(RandomNumberGenerator.generate()).isBetween(0, 9);
    }
}
