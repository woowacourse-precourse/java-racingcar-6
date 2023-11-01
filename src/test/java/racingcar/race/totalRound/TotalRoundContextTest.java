package racingcar.race.totalRound;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.move.CarRaceRecord;
import racingcar.race.move.RoundRecord;

class TotalRoundContextTest {

  @DisplayName("총 경주 기록을 생성한다.")
  @Test
  void generateTotalRound() {
    // given
    List<CarRaceRecord> eachCarRaceRecords = List.of(
        CarRaceRecord.of("ppop", RoundRecord.of(List.of(1, 1, 2))),
        CarRaceRecord.of("popo", RoundRecord.of(List.of(1, 2, 3))),
        CarRaceRecord.of("henu", RoundRecord.of(List.of(1, 2, 3)))
    );

    // when
    TotalRoundRecord totalRoundRecord = TotalRoundContext.generateTotalRound(eachCarRaceRecords);

    // then
    assertThat(totalRoundRecord.eachRoundRecord()).hasSize(3);
    assertThat(totalRoundRecord.eachRoundRecord().get(0)).containsExactly(1,
        1, 1);
    assertThat(totalRoundRecord.eachRoundRecord().get(1)).containsExactly(1,
        2, 2);
    assertThat(totalRoundRecord.eachRoundRecord().get(2)).containsExactly(2,
        3, 3);
    assertThat(totalRoundRecord.getCarNames()).containsExactly("ppop", "popo", "henu");
    assertThat(totalRoundRecord.getFinalWinners().getWinners()).containsExactly("popo", "henu");
  }
}