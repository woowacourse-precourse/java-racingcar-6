package racingcar.domain.race.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {
    private final Rule rule = Rule.newInstance();

    @Test
    void 전진_성공_테스트() {
        // given
        final int MOVING_FORWARD = 4;

        // when
        boolean forward = rule.isForward(MOVING_FORWARD);

        // then
        assertThat(forward)
                .isTrue();
    }

    @Test
    void 전진_실패_테스트() {
        // given
        final int STOP = 3;

        // when
        boolean forward = rule.isForward(STOP);

        // then
        assertThat(forward)
                .isFalse();
    }

}