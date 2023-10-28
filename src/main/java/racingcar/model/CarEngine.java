package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarEngine {
    public boolean moveCar() {
        int movement = Randoms.pickNumberInRange(0,9);
        if(movement >= 4) {
            return true;
        }
        return false;
    }

    public void countMovement() {

    }

    public void finishRace() {

    }
}
