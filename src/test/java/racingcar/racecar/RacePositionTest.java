package racingcar.racecar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacePosition;

public class RacePositionTest {

    @Test
    @DisplayName("RacePosition 대소비교")
    void racePositionCompareTest() {
        //given
        RacePosition racePosition1 = new RacePosition();
        RacePosition racePosition2 = new RacePosition();

        //when
        racePosition1.moveForward();
        int compare = racePosition1.compareTo(racePosition2);

        //then
        assertThat(compare).isEqualTo(1);
    }
}
