package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCalculator {

    List<Car> carList;

    public String getWinners(Cars cars) {
        carList = cars.getCars();

        String winners = carList.stream()
                .filter(car -> car.getMoveCount() == getMaxCount())
                .map(car -> car.getCarName())
                .collect(Collectors.joining(", "));

        return winners;
    }

    private Integer getMaxCount() {
        Integer max = carList.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .getAsInt();

        return max;
    }
}
