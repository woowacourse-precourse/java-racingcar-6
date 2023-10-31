package racingcar.race.move;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import racingcar.race.ValidatedRacingCar;

public class MoveContext {

  public List<CarRaceRecord> generateRaceRecords(int roundCount, List<ValidatedRacingCar> racingCars,
      IntFunction<Movement> movementFunction){
    return racingCars.stream().map(car -> race(roundCount, car.getName(), movementFunction))
        .toList();
  }

  private CarRaceRecord race(int roundCount, String carName,
      IntFunction<Movement> movementFunction) {
    return CarRaceRecord.of(carName, generateRoundRecord(roundCount, movementFunction));
  }

  private RoundRecord generateRoundRecord(int roundCount, IntFunction<Movement> movementFunction) {
    List<Movement> movements = generateMovements(roundCount, movementFunction);
    List<Integer> list = movements.stream().map(Movement::getNumber).toList();
    return RoundRecord.of(calculateCumulativeSums(1, list, new ArrayList<>()));
  }

  private List<Movement> generateMovements(int roundCount, IntFunction<Movement> movementFunction) {
    return IntStream.range(0, roundCount)
        .mapToObj(movementFunction)
        .toList();
  }

  private List<Integer> calculateCumulativeSums(int currentLimit, List<Integer> movementNumbers,
      List<Integer> cumulativeSums) {
    if (currentLimit > movementNumbers.size()) {
      return cumulativeSums;
    }
    cumulativeSums.add(calculateSumUpToLimit(currentLimit, movementNumbers));
    return calculateCumulativeSums(currentLimit + 1, movementNumbers, cumulativeSums);
  }

  private int calculateSumUpToLimit(int n, List<Integer> movementNumbers) {
    return movementNumbers.stream().limit(n).mapToInt(Integer::intValue).sum();
  }
}
