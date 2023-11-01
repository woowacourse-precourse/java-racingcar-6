package racingcar.race.move;

import java.util.List;

public class RoundRecord {

  private final List<Integer> roundRaceResults;

  private RoundRecord(List<Integer> roundRaceResults) {
    this.roundRaceResults = roundRaceResults;
  }

  public static RoundRecord of(List<Integer> roundRaceResults) {
    return new RoundRecord(roundRaceResults);
  }

  public List<Integer> getRoundRaceResults() {
    return roundRaceResults;
  }

  public int lastRoundRaceResult() {
    return roundRaceResults.get(roundRaceResults.size() - 1);
  }
}
