package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.domain.RacingConfig.MAX_NUMBER;
import static racingcar.domain.RacingConfig.MIN_NUMBER;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.FinalResult;
import racingcar.domain.SingleRoundResult;

public class RacingModel {

    public FinalResult startRacingGame(String[] carNames, int finalRound) {
        List<Car> cars = generateCars(carNames, finalRound);
        List<SingleRoundResult> singleRoundResults = new ArrayList<>();

        do {
            moveCars(cars);

            singleRoundResults.add(generateSingleRoundResult(cars));
        } while (cars.stream().allMatch(Car::hasMoreRound));

        return new FinalResult(singleRoundResults, findWinnerNames(cars));
    }

    private List<Car> generateCars(String[] carNames, int finalRound) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName,0,finalRound,0,new ArrayList<>()));
        }
        return cars;
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
    }
    private int generateRandomNumber() {
        return pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }

    private SingleRoundResult generateSingleRoundResult(List<Car> cars) {
        List<String> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.generateMoveHistoryMark());
        }
        return new SingleRoundResult(results);
    }

    private List<String> findWinnerNames(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 경주 결과를 찾을 수 없습니다."));

        return cars.stream()
                .filter(car -> car.isWinner(maxDistance))
                .map(Car::getName)
                .toList();
    }
}
