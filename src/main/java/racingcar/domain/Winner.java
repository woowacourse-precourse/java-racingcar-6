package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<String> findWinners(List<Car> carList) {
        List<String> winners = new ArrayList<>();
        int winPosition = findMaxPosition(carList);

        carList.stream()
                .filter(car -> car.isWinner(winPosition))
                .forEach(car -> winners.add(car.getName()));

        return winners;
    }

    private int findMaxPosition(List<Car> carList) {
        return carList.stream()
                .map(Car::positionNumber)
                .reduce(Integer::max).orElse(0);
    }
}
