package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RoundHistoryTest {

    @DisplayName("현재 라운드와 라운드 별 자동차 정보를 가지는 객체를 생성한다.")
    @Test
    void createRoundHistory() {
        // given
        NumberOfRound currentRound = new NumberOfRound(1);
        Cars cars = new Cars(List.of("pobi", "crong", "honux"));

        // when
        RoundHistory roundHistory = new RoundHistory(currentRound, new RoundResult(cars.getCurrentStatus()));

        // then
        Assertions.assertEquals(currentRound, roundHistory.currentRound());
        Assertions.assertEquals(cars.getCurrentStatus(), roundHistory.roundResult().results());
    }
}
