package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.domain.RacingConfig.MAX_NUMBER;
import static racingcar.domain.RacingConfig.MIN_NUMBER;
import static racingcar.utils.ConvertListStringToString.convertListStringToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingFinalResult;
import racingcar.domain.RacingRoundResult;

public class RacingModel {

    public RacingFinalResult proceed(String[] carNames, int round) {
        List<Car> cars = generateCars(carNames, round);
        List<RacingRoundResult> roundResults = new ArrayList<>();

        do {
            assignRandomNumbersToCars(cars);
            moveCars(cars);
            roundResults.add(createRacingRoundResult(cars));
        } while (cars.stream().allMatch(car -> car.getRound() < car.getFinalRound()));

        return new RacingFinalResult(roundResults, findWinnerNames(cars));
    }

    private List<Car> generateCars(String[] carNames, int round) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName,0,0,round,0,new ArrayList<>()));
        }
        return cars;
    }

    private void assignRandomNumbersToCars(List<Car> cars) {
        for (Car car : cars) {
            car.setRandomNumber(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public RacingRoundResult createRacingRoundResult (List<Car> cars){
        List<String> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(createCarMoveHistory(car));
        }
        return new RacingRoundResult(results);
    }

    private String createCarMoveHistory(Car car) {
        String history = convertListStringToString(car.getMoveHistoryWithoutSpace());
        return String.format("%s : %s",car.getName(),history);
    }

    public List<String> findWinnerNames(List<Car> cars) {
        int maxResult = cars.stream()
                .mapToInt(Car::getMoveResult)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());

        return cars.stream()
                .filter(car -> car.getMoveResult() == maxResult)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
