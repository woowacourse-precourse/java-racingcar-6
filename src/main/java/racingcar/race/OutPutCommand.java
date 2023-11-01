package racingcar.race;

import racingcar.race.totalRound.TotalRoundRecord;

public class OutPutCommand {
  private final TotalRoundRecord totalRoundRecord;

  private OutPutCommand(TotalRoundRecord totalRoundRecord) {
    this.totalRoundRecord = totalRoundRecord;
  }

  public static OutPutCommand of(TotalRoundRecord totalRoundRecord) {
    return new OutPutCommand(totalRoundRecord);
  }

  public TotalRoundRecord getTotalRoundRecord() {
    return totalRoundRecord;
  }
}
