package racingcar.model;

import java.util.List;
import racingcar.vo.CarName;
import racingcar.vo.CarPosition;

public class Referee {

    private static final Integer START_POINT = 0;

    private List<CarName> winnerNames;

    public void decideWinner(final List<Car> carList) {
        CarPosition maxposition = getMaxposition(carList);
        this.winnerNames = getCarNamesForMaxposition(carList, maxposition);
    }

    private List<CarName> getCarNamesForMaxposition(List<Car> carList, CarPosition maxposition) {
        return carList.stream()
                .filter(car -> car.getCarPosition().position() == maxposition.position())
                .map(car -> car.getCarName())
                .toList();
    }

    private CarPosition getMaxposition(List<Car> carList) {
        Integer maxposition = carList.stream()
                .mapToInt(car -> car.getCarPosition().position())
                .max()
                .orElse(START_POINT);

        return new CarPosition(maxposition);
    }

    public List<CarName> getWinnerNames() {
        return winnerNames;
    }
}
