package racingcar.domain;

import java.util.List;

public class Referee {

    public List<String> determineWinners(CarManager carManager) {
        List<Car> winners = carManager.getWinners();
        return winners.stream()
                .map(Car::getName)
                .toList();
    }

}
