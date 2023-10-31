package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> findWinner() {
        int winnersPosition = findWinnersPosition();
        return carList.stream()
                .filter(car -> car.isWinner(winnersPosition))
                .map(Car::getName)
                .collect(Collectors.toList());

    }

    public int findWinnersPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
