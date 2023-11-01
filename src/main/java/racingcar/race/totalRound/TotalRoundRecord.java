package racingcar.race.totalRound;

import java.util.List;

public class TotalRoundRecord {

  private final List<String> carNames;
  private final EachRoundRecords eachRoundRecords;

  private final FinalWinners finalWinners;

  private TotalRoundRecord(List<String> carNames, EachRoundRecords eachRoundRecords,
      FinalWinners finalWinners) {
    this.carNames = carNames;
    this.eachRoundRecords = eachRoundRecords;
    this.finalWinners = finalWinners;
  }

  public static TotalRoundRecord of(List<String> carNames, EachRoundRecords roundRecords,
      FinalWinners finalWinners) {
    return new TotalRoundRecord(carNames, roundRecords, finalWinners);
  }

  public List<String> getCarNames() {
    return carNames;
  }

  public List<List<Integer>> eachRoundRecord() {
    return eachRoundRecords.getEachRoundRecords();
  }

  public FinalWinners getFinalWinners() {
    return finalWinners;
  }
}
