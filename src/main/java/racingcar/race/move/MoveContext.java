package racingcar.race.move;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class MoveContext {

  private MoveContext() {
  }

  public static List<CarRaceRecord> generateRaceRecords(int roundCount, List<String> racingCars,
      IntFunction<Movement> movementFunction) {
    return racingCars.stream().map(car -> race(roundCount, car, movementFunction))
        .toList();
  }

  private static CarRaceRecord race(int roundCount, String carName,
      IntFunction<Movement> movementFunction) {
    return CarRaceRecord.of(carName, generateRoundRecord(roundCount, movementFunction));
  }

  private static RoundRecord generateRoundRecord(int roundCount,
      IntFunction<Movement> movementFunction) {
    List<Movement> movements = generateMovements(roundCount, movementFunction);
    List<Integer> list = movements.stream().map(Movement::getNumber).toList();
    return RoundRecord.of(calculateCumulativeSums(1, list, new ArrayList<>()));
  }

  private static List<Movement> generateMovements(int roundCount,
      IntFunction<Movement> generateMovement) {
    return IntStream.range(0, roundCount)
        .mapToObj(generateMovement)
        .toList();
  }

  private static List<Integer> calculateCumulativeSums(int currentLimit,
      List<Integer> movementNumbers,
      List<Integer> cumulativeSums) {
    if (currentLimit > movementNumbers.size()) {
      return cumulativeSums;
    }
    cumulativeSums.add(calculateSumUpToLimit(currentLimit, movementNumbers));
    return calculateCumulativeSums(currentLimit + 1, movementNumbers, cumulativeSums);
  }

  private static int calculateSumUpToLimit(int n, List<Integer> movementNumbers) {
    return movementNumbers.stream().limit(n).mapToInt(Integer::intValue).sum();
  }
}
