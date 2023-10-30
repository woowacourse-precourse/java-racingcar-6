package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.FinalRoundResult;
import racingcar.domain.MovementHistory;
import racingcar.domain.Round;
import racingcar.domain.SingleRoundResult;

public class RacingModel {

    public FinalRoundResult startRacingGame(String[] carNames, int finalRound) {
        List<Car> cars = generateCars(carNames, finalRound);
        List<SingleRoundResult> roundResults = race(cars);

        return new FinalRoundResult(roundResults, identifyWinners(cars));
    }

    private List<Car> generateCars(String[] carNames, int totalRound) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName, new Round(totalRound)))
                .toList();
    }

    List<SingleRoundResult> race(List<Car> cars) {
        List<SingleRoundResult> singleRoundResults = new ArrayList<>();
        do {
            cars.forEach(Car::move);
            singleRoundResults.add(new SingleRoundResult(cars,extractMovementHistories(cars)));
        } while (cars.stream().noneMatch(Car::isReachedFinalRound));
        return singleRoundResults;
    }

    private List<MovementHistory> extractMovementHistories(List<Car> cars) {
        return cars.stream().map(Car::getMovementHistory).toList();
    }

    private List<Car> identifyWinners(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.isWinner(maxDistance))
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
