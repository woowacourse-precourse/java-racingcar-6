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
}