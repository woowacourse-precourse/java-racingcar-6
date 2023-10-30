package racingcar.model.race;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int carRank;

    public Car(String carName) {
        this.carName = carName + " : ";
        this.carRank = 0;
    }

    public String getCarName() {
        return carName;
    }
    public int getCarRank() {
        return carRank;
    }

    public String printMovement() {
        if (moveCar()) {
            carName = carName + "-";
            carRank++;
            return carName;
        }
        return carName;
    }

    public boolean moveCar() {
        int drive = Randoms.pickNumberInRange(0,9);
        if (drive >= 4) {
            return true;
        }
        return false;
    }
}
