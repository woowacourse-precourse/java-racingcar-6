package racingcar.domain;

import java.util.List;

class Referee {
    Referee() {
    }

    List<Car> judgeWinner(List<Car> cars) {
        int maxCount = cars.stream().mapToInt(Car::moveCount).max().orElse(-1);
        return cars.stream().filter(car -> car.moveCount() == maxCount).toList();
    }
}
