package racingcar.race.move;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveContextTest {

  @DisplayName("전진 테스트")
  @Test
  void if_generateRoundRecord_go() {
    // given
    MoveContext moveContext = new MoveContext();

    // when
    List<CarRaceRecord> carRaceRecords = moveContext.generateRaceRecords(3,
        List.of("poo"), (n) -> new Go(1));

    // then
    assertThat(carRaceRecords).hasSize(1);
    assertThat(carRaceRecords.get(0).getCarName()).isEqualTo("poo");
    assertThat(carRaceRecords.get(0).getRoundRecord().getRoundRaceResults()).containsExactly(1,2,3);
  }

  @DisplayName("멈춤 테스트")
  @Test
  void if_generateRoundRecord_stop() {
    // given
    MoveContext moveContext = new MoveContext();

    // when
    List<CarRaceRecord> carRaceRecords = moveContext.generateRaceRecords(3,
        List.of("다함"), (n) -> new Stop(0));
    // then
    assertThat(carRaceRecords).hasSize(1);
    assertThat(carRaceRecords.get(0).getCarName()).isEqualTo("다함");
    assertThat(carRaceRecords.get(0).getRoundRecord().getRoundRaceResults()).containsExactly(0,0,0);
  }
}