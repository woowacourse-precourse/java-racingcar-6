package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarRankingManager {
    public List<String> getWinners(List<RacingCar> cars) {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
