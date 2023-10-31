package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {
    public List<Winner> judgeGameResult(final List<Car> cars) {
        return cars.stream()
                .filter(car1 -> cars.stream()
                        .allMatch(car2 -> car1.isLead(car2)))
                .map(car -> new Winner(car.getName()))
                .toList();
    }
}
