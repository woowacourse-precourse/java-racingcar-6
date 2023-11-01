package racingcar.race;

import racingcar.race.totalRound.TotalRoundRecord;

public class RaceEndedEvent {

  private final TotalRoundRecord totalRoundRecord;

  private RaceEndedEvent(TotalRoundRecord totalRoundRecord) {
    this.totalRoundRecord = totalRoundRecord;
  }

  public static RaceEndedEvent of(TotalRoundRecord totalRoundRecord) {
    return new RaceEndedEvent(totalRoundRecord);
  }

  public TotalRoundRecord getTotalRoundRecord() {
    return totalRoundRecord;
  }

  public OutPutCommand outPutCommand() {
    return OutPutCommand.of(totalRoundRecord);
  }
}
