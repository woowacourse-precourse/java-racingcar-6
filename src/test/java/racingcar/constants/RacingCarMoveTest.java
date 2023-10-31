package racingcar.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 이동에 대해 ")
class RacingCarMoveTest {

    @Test
    @DisplayName("위치가 0보다 크면 계속 진행중이다.")
    void check_processing() {
        //given
        //when
        boolean isProcessing = RacingCarMove.isProcessing(5);

        //then
        assertThat(isProcessing).isTrue();
    }

    @Test
    @DisplayName("시도 횟수가 한 단계씩 줄어든다.")
    void update_attempt_count() {
        //given
        //when
        int attemptCount = RacingCarMove.decreaseAttemptCount(5);
        //then
        assertThat(attemptCount).isEqualTo(4);
    }
}