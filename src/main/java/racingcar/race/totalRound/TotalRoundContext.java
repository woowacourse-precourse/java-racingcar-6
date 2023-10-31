package racingcar.race.totalRound;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.race.move.CarRaceRecord;

public class TotalRoundContext {

  public TotalRoundRecord generateTotalRound(List<CarRaceRecord> raceRecords) {
    List<String> carNames = findCarNames(raceRecords);
    FinalWinners winners = findWinners(raceRecords);
    List<List<Integer>> eachRoundRecord = generateEachRoundRecord(raceRecords);
    return TotalRoundRecord.of(carNames, EachRoundRecords.of(eachRoundRecord), winners);
  }

  private List<String> findCarNames(List<CarRaceRecord> raceRecords) {
    return raceRecords.stream().map(CarRaceRecord::getCarName).toList();
  }

  private List<List<Integer>> generateEachRoundRecord(List<CarRaceRecord> raceRecords) {
    List<List<Integer>> eachCarRoundRecord = getEachCarRoundRecord(raceRecords);
    int size = eachCarRoundRecord.get(0).size();
    return IntStream.range(0, size)
        .mapToObj(i -> eachCarRoundRecord.stream()
            .map(list -> list.get(i))
            .toList())
        .toList();
  }

  private List<List<Integer>> getEachCarRoundRecord(List<CarRaceRecord> raceRecords) {
    return raceRecords.stream()
        .map(c -> c.getRoundRecord().getRoundRaceResults())
        .toList();
  }

  private FinalWinners findWinners(List<CarRaceRecord> raceRecords) {
    return FinalWinners.of(findWinnerCarNames(raceRecords, findMax(raceRecords)));
  }

  private List<String> findWinnerCarNames(List<CarRaceRecord> raceRecords, Integer max) {
    return raceRecords.stream().filter(carRaceRecord -> carRaceRecord.lastRoundRaceResult() == max)
        .map(CarRaceRecord::getCarName).toList();
  }

  private Integer findMax(List<CarRaceRecord> raceRecords) {
    return raceRecords.stream().max(Comparator.comparing(CarRaceRecord::lastRoundRaceResult))
        .map(CarRaceRecord::lastRoundRaceResult).orElse(0);
  }
}
