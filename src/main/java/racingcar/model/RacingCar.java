package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.global.RacingCarGameConfig.*;

public class RacingCar {
    public String name;
    private int carMoveCount;

    public RacingCar(String name) {
        this.name = name;
    }

    public void incrementCarMoveCount() {
        this.carMoveCount++;
    }

    public int getCarMoveCount() {
        return this.carMoveCount;
    }

    public void moveCar() {
        int moveFlagNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        if (moveFlagNumber >= STANDARD_NUMBER) {
            this.incrementCarMoveCount();
        }
    }
}
