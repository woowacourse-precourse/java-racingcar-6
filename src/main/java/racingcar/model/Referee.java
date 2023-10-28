package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.vo.CarName;

public class Referee {

    private static final Integer START_POINT = 0;

    private List<CarName> winnerNames;

    public List<CarName> getWinnerNames() {
        return winnerNames;
    }

    public void decideWinner(final Cars cars) {
        List<Car> carList = cars.getCarList();
        Integer maxStep = getMaxStep(carList);

        List<CarName> winners = getWinnerNames(carList, maxStep);

        this.winnerNames = Collections.unmodifiableList(winners);
    }

    private List<CarName> getWinnerNames(List<Car> cars, Integer maxStep) {
        return cars.stream()
                .filter(car -> car.getStep() == maxStep)
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }

    private Integer getMaxStep(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getStep)
                .max()
                .orElse(START_POINT);
    }
}
