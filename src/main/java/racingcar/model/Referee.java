package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.vo.CarDistance;
import racingcar.vo.CarName;

public class Referee {

    private static final Integer START_POINT = 0;

    private List<CarName> winnerNames;

    public List<CarName> getWinnerNames() {
        return winnerNames;
    }

    public void decideWinner(final Cars cars) {
        List<Car> carList = cars.getCarList();
        CarDistance maxDistance = getMaxDistance(carList);

        List<CarName> winners = getWinnerNames(carList, maxDistance);

        this.winnerNames = Collections.unmodifiableList(winners);
    }

    private List<CarName> getWinnerNames(List<Car> cars, CarDistance maxDistance) {
        return cars.stream()
                .filter(car -> car.getCarDistance().distance() == maxDistance.distance())
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }


    private CarDistance getMaxDistance(List<Car> cars) {
        Integer maxDistance = cars.stream()
                .mapToInt(car -> car.getCarDistance().distance())
                .max()
                .orElse(START_POINT);

        return new CarDistance(maxDistance);
    }
}
