package racingcar.model;

import java.util.List;
import racingcar.vo.CarDistance;
import racingcar.vo.CarName;

public class Referee {

    private static final Integer START_POINT = 0;

    private List<CarName> winnerNames;

    public void decideWinner(final List<Car> carList) {
        CarDistance maxDistance = getMaxDistance(carList);
        this.winnerNames = getCarNameForMaxDistance(carList, maxDistance);
    }

    private List<CarName> getCarNameForMaxDistance(List<Car> carList, CarDistance maxDistance) {
        return carList.stream()
                .filter(car -> car.getCarDistance().distance() == maxDistance.distance())
                .map(car -> car.getCarName())
                .toList();
    }

    private CarDistance getMaxDistance(List<Car> carList) {
        Integer maxDistance = carList.stream()
                .mapToInt(car -> car.getCarDistance().distance())
                .max()
                .orElse(START_POINT);

        return new CarDistance(maxDistance);
    }

    public List<CarName> getWinnerNames() {
        return winnerNames;
    }
}
