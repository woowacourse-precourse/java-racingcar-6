package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Referee {

    private static final Integer START_POINT = 0;

    private List<String> winnerNames;

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public void decideWinner(final Cars cars) {
        List<Car> carList = cars.getCarList();
        Integer maxStep = getMaxStep(carList);

        List<String> winners = getWinnerNames(carList, maxStep);

        this.winnerNames = Collections.unmodifiableList(winners);
    }

    private List<String> getWinnerNames(List<Car> cars, Integer maxStep) {
        return cars.stream()
                .filter(car -> car.getStep() == maxStep)
                .map(Car::getName)
                .toList();
    }

    private Integer getMaxStep(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getStep)
                .max()
                .orElse(START_POINT);
    }
}
