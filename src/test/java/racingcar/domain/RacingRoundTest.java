package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingRoundTest {
    private static final String ROUND = "4";
    @Test
    @DisplayName("getRound 함수 기능 테스트")
    void 라운드_반환_기능_테스트() {
        //given
        RacingRound racingRound = new RacingRound(ROUND);
        //then
        assertEquals(racingRound.getRound(), 4);
    }
}
