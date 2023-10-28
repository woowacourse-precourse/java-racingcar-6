package racingcar.domain;

import java.util.List;

public class Judgement {
    public List<Winner> judgeGameResult(final List<Car> cars) {
        return cars.stream()
                .filter(Car::isLead)
                .map(car -> new Winner(car.getName()))
                .toList();
    }
}
