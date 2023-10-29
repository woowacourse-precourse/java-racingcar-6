package racingcar.utils;

import java.util.List;
import racingcar.RacingBoard;
import racingcar.RacingCar;

public final class Print {
    public void currentRacingRank(final List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getNameAndDistance());
        }

        System.out.println();
    }

    public void winner(final RacingBoard racingBoard) {
        System.out.println(racingBoard.carsWithMaxDistance());
    }
}
