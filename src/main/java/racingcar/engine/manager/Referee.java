package racingcar.engine.manager;

import java.util.List;
import racingcar.engine.domain.Car;

public class Referee {
    public Referee() {
    }

    public List<Car> getWinner(List<Car> cars) {
        Integer maximumProgress = cars.stream().map(Car::getProgress).max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("알수 없는 오류가 발생하였습니다."));

        return cars.stream()
                .filter(car -> car.getProgress() == maximumProgress)
                .toList();

    }
}
