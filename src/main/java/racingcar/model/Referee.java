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

    public void decideWinner(final List<Car> carList) {
        CarDistance maxDistance = getMaxDistance(carList);
        List<CarName> winners = getWinnerNames(carList, maxDistance);

        this.winnerNames = Collections.unmodifiableList(winners);
    }

    private List<CarName> getWinnerNames(List<Car> carList, CarDistance maxDistance) {
        return carList.stream()
                .filter(car -> car.getCarDistance().distance() == maxDistance.distance())
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }

    private CarDistance getMaxDistance(List<Car> carList) {
        Integer maxDistance = carList.stream()
                .mapToInt(car -> car.getCarDistance().distance())
                .max()
                .orElse(START_POINT);

        return new CarDistance(maxDistance);
    }
}
