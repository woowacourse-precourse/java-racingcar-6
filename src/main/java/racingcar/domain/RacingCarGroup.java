package racingcar.domain;

import java.util.List;

public class RacingCarGroup {

    private final List<RacingCar> racingCars;

    public RacingCarGroup(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void moveForward() {
        for (RacingCar racingCar : racingCars) {
            RandomNumber randomNumber = new RandomNumber();

            if (randomNumber.isMovePossible()) {
                racingCar.forWard();
            }
        }
    }
}
