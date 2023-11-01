package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean canMoveForward(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
