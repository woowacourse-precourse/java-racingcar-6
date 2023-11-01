package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.domain.result.CarResult;
import racingcar.domain.result.FinalResult;
import racingcar.domain.movement.MovementHistory;
import racingcar.domain.round.Round;
import racingcar.domain.result.RoundResult;
import racingcar.utils.RaceExecutionException;

public class RacingModel {

    public FinalResult startRacing(String[] carNames, int finalRound) {
        List<Car> cars = generateCars(carNames, finalRound);
        List<RoundResult> roundResults = race(cars);

        return new FinalResult(roundResults, identifyWinners(cars));
    }

    private List<Car> generateCars(String[] carNames, int totalRound) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName, new RandomMovementStrategy(), new Round(totalRound)))
                .toList();
    }

    private List<RoundResult> race(List<Car> cars) {
        List<RoundResult> roundResults = new ArrayList<>();
        try {
            while (allCarsHasNotReachedFinalRound(cars)){
                cars.forEach(Car::processRound);
                roundResults.add(generateCarResult(cars));
            }
        } catch (Exception e) {
            throw new RaceExecutionException("경주 중 오류가 발생했습니다.", e);
        }
        return roundResults;
    }

    private RoundResult generateCarResult(List<Car> cars) {
        List<CarResult> carResults = cars.stream()
                .map(car -> new CarResult(car.getName(), car.getMovementHistory().getMovedDistance()))
                .toList();
        return new RoundResult(carResults);
    }

    private boolean allCarsHasNotReachedFinalRound(List<Car> cars) {
        return cars.stream().noneMatch(Car::hasReachedFinalRound);
    }

    private List<Car> identifyWinners(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.hasReachedMaxDistance(maxDistance))
                .toList();
    }

    private int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .map(Car::getMovementHistory)
                .mapToInt(MovementHistory::getMovedDistance)
                .max()
                .orElseThrow(() -> new RaceExecutionException("자동차 경주 결과를 찾을 수 없습니다."));
    }
}
