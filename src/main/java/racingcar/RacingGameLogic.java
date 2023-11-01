package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameLogic {

    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        int maxLength = getLongestDistance(racingCars);

        return racingCars.stream()
                .filter(car -> car.getMovement().length() == maxLength)
                .collect(Collectors.toList());
    }

    private int getLongestDistance(List<RacingCar> racingCars) {
        return racingCars.stream()
                .mapToInt(car -> car.getMovement().length())
                .max()
                .orElse(0);
    }
}
