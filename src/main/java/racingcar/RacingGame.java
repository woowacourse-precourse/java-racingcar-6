package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void play() {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            racingCar.move(randomNumber);
        }
    }
}
