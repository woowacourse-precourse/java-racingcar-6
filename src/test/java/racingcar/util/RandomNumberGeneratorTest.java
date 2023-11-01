package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    @RepeatedTest(100)
    void 범위내의_랜덤한_상수_생성_확인() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        // when
        int generate = numberGenerator.generate();

        // then
        assertThat(generate).isBetween(0, 9);
    }
}