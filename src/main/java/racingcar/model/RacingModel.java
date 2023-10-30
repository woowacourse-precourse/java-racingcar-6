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

public class RacingModel {

    public FinalResult startRacing(String[] carNames, int finalRound) {
        List<Car> cars = generateCars(carNames, finalRound);
        List<RoundResult> roundResults = race(cars);

        return new FinalResult(roundResults, identifyWinners(cars));
    }

    private List<Car> generateCars(String[] carNames, int totalRound) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName, new RandomMovementStrategy(),new Round(totalRound)))
                .toList();
    }

    public List<RoundResult> race(List<Car> cars) {
        List<RoundResult> roundResults = new ArrayList<>();
        do {
            cars.forEach(Car::processRound);

            List<CarResult> carResults = cars.stream()
                    .map(car -> new CarResult(car.getName(), car.getMovementHistory().getMovedDistance()))
                    .toList();
            roundResults.add(new RoundResult(carResults));
        } while (cars.stream().noneMatch(Car::hasReachedFinalRound));

        return roundResults;
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
                .orElseThrow(() -> new IllegalArgumentException("자동차 경주 결과를 찾을 수 없습니다."));
    }
}
