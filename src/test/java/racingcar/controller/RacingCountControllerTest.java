package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCountControllerTest {

    @Test
    @DisplayName("입력받은 회수를 숫자로 변경")
    public void makeRacingCount() {
        //given
        String inputRacingCount = "100";

        //when
        int result = RacingCountController.makeRacingCount(inputRacingCount);

        //then
        assertThat(result).isEqualTo(100);
    }
}