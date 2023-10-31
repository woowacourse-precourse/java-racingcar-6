package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.race.move.CarRaceRecord;
import racingcar.race.move.Go;
import racingcar.race.move.MoveContext;
import racingcar.race.move.Movement;
import racingcar.race.totalRound.TotalRoundContext;
import racingcar.race.totalRound.TotalRoundRecord;

public class RaceContext {

  public RaceEndedEvent start(RaceStartCommand command) {
    List<CarRaceRecord> carRaceRecords = race(command);
    TotalRoundRecord totalRoundRecord = getTotalRoundRecord(carRaceRecords);
    return RaceEndedEvent.of(totalRoundRecord);
  }

  private TotalRoundRecord getTotalRoundRecord(List<CarRaceRecord> carRaceRecords) {
    TotalRoundContext totalRoundContext = new TotalRoundContext();
    return totalRoundContext.generateTotalRound(carRaceRecords);
  }

  private List<CarRaceRecord> race(RaceStartCommand command) {
    MoveContext moveContext = new MoveContext();
    return moveContext.generateRaceRecords(
        command.getRoundCount().getRacingCount(),
        command.getRacingCars(), this::moveRuleFunction);
  }

  private Movement moveRuleFunction(int number) {
    int random = Randoms.pickNumberInRange(0, 9);
    if (random >= 4) {
      return new Go(1);
    }
    return new Go(0);
  }
}
