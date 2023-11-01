package racingcar.racing;


import racingcar.car.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    private static final String ERROR_DUPLICATE_CAR_NAME_EXIST = "중복된 이름이 존재합니다.";
    private static final String ERROR_ROUND_NUMBER_MUST_POSITIVE = "라운드수는 양수여야 합니다.";

    private final List<Car> cars;
    private final int roundNumber;

    public Racing(List<Car> cars, int roundNumber) {
        validateIsDuplicateCarNameExist(cars);
        validateIsPositive(roundNumber);
        this.cars = cars;
        this.roundNumber = roundNumber;
    }

    public RacingResult race() {
        List<RacingRoundResult> racingHistory = runRace();
        List<String> winnerNames = getWinnerNames();
        return new RacingResult(winnerNames, racingHistory);
    }

    private List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(car, maxPosition, winnerNames);
        }
        return winnerNames;
    }

    private void addIfWinner(Car car, int maxPosition, List<String> winnerNames) {
        if (car.isPosition(maxPosition)) {
            winnerNames.add(car.getName());
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<RacingRoundResult> runRace() {
        List<RacingRoundResult> racingResult = new ArrayList<>();
        for (int i = 0; i < roundNumber; i++) {
            List<CarStatus> currentCarStatuses = runRound();
            racingResult.add(new RacingRoundResult(currentCarStatuses));
        }
        return racingResult;
    }

    private List<CarStatus> runRound() {
        moveCars();
        return getCurrentCarStatuses();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<CarStatus> getCurrentCarStatuses() {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            carStatuses.add(car.getCurrentStatus());
        }
        return carStatuses;
    }

    private void validateIsDuplicateCarNameExist(List<Car> cars) {
        Set<String> carNames = getCarNames(cars);
        if (carNames.size() != cars.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_CAR_NAME_EXIST);
        }
    }

    private void validateIsPositive(int roundNumber) {
        if (roundNumber <= 0) {
            throw new IllegalArgumentException(ERROR_ROUND_NUMBER_MUST_POSITIVE);
        }
    }

    private Set<String> getCarNames(List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
