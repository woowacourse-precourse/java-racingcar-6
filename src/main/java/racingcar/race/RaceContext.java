package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.Input.RaceStartCommand;
import racingcar.race.move.CarRaceRecord;
import racingcar.race.move.Go;
import racingcar.race.move.MoveContext;
import racingcar.race.move.Movement;
import racingcar.race.totalRound.TotalRoundContext;
import racingcar.race.totalRound.TotalRoundRecord;

public class RaceContext {

  private RaceContext() {
  }

  public static RaceEndedEvent start(RaceStartCommand command) {
    List<CarRaceRecord> carRaceRecords = race(command);
    TotalRoundRecord totalRoundRecord = getTotalRoundRecord(carRaceRecords);
    return RaceEndedEvent.of(totalRoundRecord);
  }

  private static TotalRoundRecord getTotalRoundRecord(List<CarRaceRecord> carRaceRecords) {
    TotalRoundContext totalRoundContext = new TotalRoundContext();
    return totalRoundContext.generateTotalRound(carRaceRecords);
  }

  private static List<CarRaceRecord> race(RaceStartCommand command) {
    return MoveContext.generateRaceRecords(
        command.getRoundCount().getRacingCount(),
        command.getRacingCars().getNames(), RaceContext::moveRuleFunction);
  }

  private static Movement moveRuleFunction(int number) {
    int random = Randoms.pickNumberInRange(0, 9);
    if (random >= 4) {
      return new Go(1);
    }
    return new Go(0);
  }
}
