package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RaceDecisionMakerTest {
    @Test
    void 생성하는_랜덤값의_범위() {
        for (int i = 0; i < 5; ++i) {
            assertThat(RaceDecisionMaker.pickNumber()).isBetween(0, 9);
        }
    }
}