package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<RacingCar> racingCars;

    public Winner(List<RacingCar> racingCars) {
        int winnerValue = getWinnerValue(racingCars);
        this.racingCars = racingCars.stream()
                .filter(car -> car.getMove() == winnerValue)
                .collect(Collectors.toList());
    }

    private Integer getWinnerValue(List<RacingCar> racingCarList) {
        return racingCarList
                .stream()
                .mapToInt(RacingCar::getMove)
                .max()
                .orElse(0);
    }

    public List<String> getWinners() {
        return racingCars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
