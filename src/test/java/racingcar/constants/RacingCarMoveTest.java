package racingcar.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

}