package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String carName;
    public int raceStatus;

    public Car(String carNameInput) {
        this.carName = carNameInput;
        this.raceStatus = 0;
    }

    public void tryToMove() {
        int randResult = Randoms.pickNumberInRange(0, 9);
        if (randResult >= 4) {
            move();
        }
    }

    public void move(){
        raceStatus+= 1;
    }

}
