package racingcar.v4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
class ForwardTest {
    @Test
    void randomNums는_0에서_9사이의_값을_반환한다() {
        Forward forward = new Forward();
        for (int i = 0; i < 1000; i++) {
            int randomNum = forward.randomNums();
            assertThat(randomNum).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
        }
    }

    @Test
    void canForward는_randomsNum이_4이상일_때_true를_반환한다() {
        Forward forward = new Forward();

        assertThat(forward.canForward(4)).isTrue();
        assertThat(forward.canForward(5)).isTrue();
        assertThat(forward.canForward(9)).isTrue();
    }

    @Test
    void canForward는_randomsNum이_4미만일_때_false를_반환한다() {
        Forward forward = new Forward();

        assertThat(forward.canForward(0)).isFalse();
        assertThat(forward.canForward(1)).isFalse();
        assertThat(forward.canForward(3)).isFalse();
    }


}