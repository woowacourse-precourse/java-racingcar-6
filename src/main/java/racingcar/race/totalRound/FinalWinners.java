package racingcar.race.totalRound;

import java.util.List;

public class FinalWinners {

  private final List<String> winners;

  private FinalWinners(List<String> winners) {
    this.winners = winners;
  }

  public static FinalWinners of(List<String> winners) {
    return new FinalWinners(winners);
  }

  public List<String> getWinners() {
    return winners;
  }
}
