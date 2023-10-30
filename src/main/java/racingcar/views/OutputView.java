package racingcar.views;

import java.util.List;

import racingcar.models.RacingCar;

public class OutputView {
    public void printRoundResult(List<RacingCar> racingCars) {
        racingCars.forEach((RacingCar racingCar) -> {
            System.out.printf("%s : %s\n", racingCar.getName(), "-".repeat(racingCar.getDistance()));
        });
    }
}
