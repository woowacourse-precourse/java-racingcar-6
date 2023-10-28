package racingcar.domain;

import java.util.List;

public class RacingCarStatusGroup {

    private final List<RacingCars> racingCars;

    public RacingCarStatusGroup(List<RacingCars> racingCars) {
        this.racingCars = racingCars;
    }

    public void moveForward() {
        for (RacingCars racingCar : racingCars) {
            RandomNumber randomNumber = new RandomNumber();

            if (randomNumber.isMovePossible()) {
                racingCar.forWard();
            }
        }
    }
}
