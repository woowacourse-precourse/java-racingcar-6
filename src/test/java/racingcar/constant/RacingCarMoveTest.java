package racingcar.constant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacingCarMove의")
public class RacingCarMoveTest {

    @Test
    @DisplayName("값이 1이상이면 true를 반환하는가")
    void is_processing_true() {
        //given
        int attemptCount = 3;

        //when
        boolean actualStatus = RacingCarMove.isProcessing(attemptCount);

        //then
        assertThat(actualStatus).isTrue();
    }

    @Test
    @DisplayName("값이 0이면 false를 반환하는가")
    void is_processing_false() {
        //given
        int attemptCount = 0;

        //when
        boolean actualStatus = RacingCarMove.isProcessing(attemptCount);

        //then
        assertThat(actualStatus).isFalse();
    }

    @Test
    @DisplayName("예측값이 줄어드는가")
    void decrease_attempt_count() {
        //given
        int input = 3;
        int expectedCount = 2;
        //when
        int actualCount = RacingCarMove.decreaseAttemptCount(input);

        //then
        assertThat(actualCount).isEqualTo(expectedCount);
    }
}