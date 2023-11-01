package racingcar.model;

import java.util.List;
import racingcar.vo.CarName;
import racingcar.vo.CarPosition;

public class Referee {

    private static final Integer START_POINT = 0;

    private List<CarName> winnerNames;

    public void decideWinner(final List<Car> carList) {
        CarPosition maxPosition = getMaxPosition(carList);
        this.winnerNames = getCarNamesForMaxPosition(carList, maxPosition);
    }

    private List<CarName> getCarNamesForMaxPosition(List<Car> carList, CarPosition maxPosition) {
        return carList.stream()
                .filter(car -> car.getCarPosition().position() == maxPosition.position())
                .map(car -> car.getCarName())
                .toList();
    }

    private CarPosition getMaxPosition(List<Car> carList) {
        Integer maxPosition = carList.stream()
                .mapToInt(car -> car.getCarPosition().position())
                .max()
                .orElse(START_POINT);

        return new CarPosition(maxPosition);
    }

    public List<CarName> getWinnerNames() {
        return winnerNames;
    }
}
