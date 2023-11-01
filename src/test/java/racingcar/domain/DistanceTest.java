package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {

    @DisplayName("자동차가 전진했다면, 위치를 변경(1증가)한다.")
    @Test
    void carMoveSuccess() throws Exception{
        //given
        int startLocation = 0;
        Distance init = new Distance(startLocation);

        //when
        Distance move = init.increase();

        //then
        assertThat(move.location()).isEqualTo(1);
    }
}