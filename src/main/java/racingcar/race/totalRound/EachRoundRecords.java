package racingcar.race.totalRound;

import java.util.List;

public class EachRoundRecords {

  private final List<List<Integer>> eachRoundRecords;

  private EachRoundRecords(List<List<Integer>> eachRoundRecords) {
    this.eachRoundRecords = eachRoundRecords;
  }

  public static EachRoundRecords of(List<List<Integer>> eachRoundRecords) {
    return new EachRoundRecords(eachRoundRecords);
  }

  public List<List<Integer>> getEachRoundRecords() {
    return eachRoundRecords;
  }

  public int size() {
    return eachRoundRecords.size();
  }
}
