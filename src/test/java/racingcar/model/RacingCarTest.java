package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private RacingCar racingCar;

    @Test
    @DisplayName("전진 마킹은 처음엔 공백이다.")
    void checkAdvanceMarkingBlank() {
        // given
        racingCar = new RacingCar("pobi");
        // when
        String advanceMarking = racingCar.getAdvanceMarking();
        // then
        assertThat(advanceMarking).isEqualTo("");
    }

    @Test
    @DisplayName("한칸 전진한다.")
    void checkRandomNumberInRange() {
        // given
        racingCar = new RacingCar("pobi");
        //when
        racingCar.advance();
        // then
        assertThat(racingCar.getAdvanceMarking()).isEqualTo("-");
    }
}
