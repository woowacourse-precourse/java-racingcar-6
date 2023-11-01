package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.IO.Input.RaceStartCommand;
import racingcar.IO.Input.UnValidatedCars;
import racingcar.IO.Input.ValidatedCars;
import racingcar.IO.Input.ValidatedRoundCount;

class RaceContextTest {

  @DisplayName("레이스 테스트")
  @Test
  void race() {
    // given
    RaceStartCommand raceStartCommand = RaceStartCommand.of(
        ValidatedCars.of(UnValidatedCars.of(List.of("poo", "zoo", "zaa"))), ValidatedRoundCount.of("4"));

    // when
    RaceEndedEvent raceEndedEvent = RaceContext.start(raceStartCommand);

    // then
    assertThat(raceEndedEvent.getTotalRoundRecord().getCarNames()).containsExactly("poo", "zoo",
        "zaa");
    assertThat(raceEndedEvent.getTotalRoundRecord().eachRoundRecord()).hasSize(4);
    assertThat(raceEndedEvent.getTotalRoundRecord().getFinalWinners().getWinners()).isNotEmpty();
  }
}