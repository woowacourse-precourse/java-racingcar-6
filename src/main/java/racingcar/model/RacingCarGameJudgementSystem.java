package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameJudgementSystem {

    public Winners judge(Cars cars) {
        int maximumMovingDistance = cars.getMaximumMovingDistance();

        List<String> winnerNames = cars.getCars().stream()
            .filter(car -> car.getTotalMovingDistance() == maximumMovingDistance)
            .map(Car::getName)
            .collect(Collectors.toList());

        return new Winners(winnerNames);
    }
}
