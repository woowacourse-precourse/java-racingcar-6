package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceContextTest {

  @DisplayName("레이스 테스트")
  @Test
  void testMethodNameHere() {
    // given
    RaceStartCommand raceStartCommand = RaceStartCommand.of(
        List.of(ValidatedRacingCar.of("poo"), ValidatedRacingCar.of("zoo"),
            ValidatedRacingCar.of("zaa")), ValidationRoundCount.of(4));

    // when
    RaceEndedEvent raceEndedEvent = RaceContext.start(raceStartCommand);

    // then
    assertThat(raceEndedEvent.getTotalRoundRecord().getCarNames()).containsExactly("poo", "zoo", "zaa");
    assertThat(raceEndedEvent.getTotalRoundRecord().eachRoundRecord()).hasSize(4);
    assertThat(raceEndedEvent.getTotalRoundRecord().getFinalWinners().getWinners()).isNotEmpty();
  }
}